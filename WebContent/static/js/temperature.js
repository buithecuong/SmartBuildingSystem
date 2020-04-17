var chartColors = {
    red: 'rgb(255, 99, 132)',
    orange: 'rgb(255, 159, 64)',
    yellow: 'rgb(255, 205, 86)',
    green: 'rgb(75, 192, 192)',
    blue: 'rgb(54, 162, 235)',
    purple: 'rgb(153, 102, 255)',
    grey: 'rgb(201, 203, 207)'
};

var color = Chart.helpers.color;
var colorNames = Object.keys(chartColors);


var tconfig = {
    type: 'line',               // 'line', 'bar', 'bubble' and 'scatter' types are supported
    data: {
        datasets: [{
            label: 'Temperature(C)',
            backgroundColor: color(chartColors.blue).alpha(0.5).rgbString(),
            borderColor: chartColors.blue,
            fill: false,
            cubicInterpolationMode: 'monotone',
            data: [] // empty at the beginning
        }]
    },
    options: {
        title: {
            display: true,
            text: 'Temperature vs Time'
        },
        layout: {
            padding: {
                left: 20,
                right: 20,
                top: 0,
                bottom: 20
            }
        },
        responsive: true,
        maintainAspectRatio: false,
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                },
                scaleLabel: {
                    display: true,
                    labelString: 'Temperature(C)'
                }
            }],
            xAxes: [{
                scaleLabel: {
                    display: true,
                    labelString: 'TimeStamp'
                },
                type: 'realtime',   // x axis will auto-scroll from right to left
                realtime: {         // per-axis options
                    duration: 20000,    // data in the past 20000 ms will be displayed
                    refresh: 5000,      // onRefresh callback will be called every 5 seconds
                    delay: 51000,        // delay of 5000 ms, so upcoming values are known before plotting a line
                    pause: false,       // chart is not paused
                    ttl: undefined,     // data will be automatically deleted as it disappears off the chart

                    // a callback to update datasets
                    onRefresh: function (chart) {

                       // query your data source and get the array of {x: timestamp, y: value} objects
                            addDatapoint(chart)
                    }
                }
            }]
        },
        plugins: {
            streaming: {            // per-chart option
                frameRate: 30       // chart is drawn 30 times every second
            }
        }
    }
}

// Get temperature chart canvas
var tempctx = document.getElementById('tempChart').getContext('2d');
window.tempChart = new Chart(tempctx, tconfig);