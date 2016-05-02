var DBD;
(function (DBD) {
    (function (JigyoTaishoshaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        JigyoTaishoshaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoTaishoshaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.JigyoTaishoshaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.JigyoTaishoshaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoTaishoshaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJigyoTaishoshaJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgJigyoTaishoshaJoho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JigyoTaishoshaJoho.Controls = Controls;
    })(DBD.JigyoTaishoshaJoho || (DBD.JigyoTaishoshaJoho = {}));
    var JigyoTaishoshaJoho = DBD.JigyoTaishoshaJoho;
})(DBD || (DBD = {}));
