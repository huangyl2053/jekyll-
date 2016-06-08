var DBZ;
(function (DBZ) {
    (function (RoreiFukushiNenkinJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        RoreiFukushiNenkinJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RoreiFukushiNenkinJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.RoreiFukushiNenkinJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.RoreiFukushiNenkinJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RoreiFukushiNenkinJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgRoreiFukushiNenkinJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgRoreiFukushiNenkinJoho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        RoreiFukushiNenkinJoho.Controls = Controls;
    })(DBZ.RoreiFukushiNenkinJoho || (DBZ.RoreiFukushiNenkinJoho = {}));
    var RoreiFukushiNenkinJoho = DBZ.RoreiFukushiNenkinJoho;
})(DBZ || (DBZ = {}));
