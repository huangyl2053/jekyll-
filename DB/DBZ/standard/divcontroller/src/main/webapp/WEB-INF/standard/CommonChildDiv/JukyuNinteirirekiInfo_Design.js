var DBZ;
(function (DBZ) {
    (function (JukyuNinteirirekiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        JukyuNinteirirekiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuNinteirirekiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JukyuNinteirirekiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JukyuNinteirirekiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuNinteirirekiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgNinteiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiRireki"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JukyuNinteirirekiInfo.Controls = Controls;
    })(DBZ.JukyuNinteirirekiInfo || (DBZ.JukyuNinteirirekiInfo = {}));
    var JukyuNinteirirekiInfo = DBZ.JukyuNinteirirekiInfo;
})(DBZ || (DBZ = {}));
