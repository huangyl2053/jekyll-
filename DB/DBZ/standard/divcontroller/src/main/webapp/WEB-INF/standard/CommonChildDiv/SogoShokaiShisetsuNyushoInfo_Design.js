var DBZ;
(function (DBZ) {
    (function (SogoShokaiShisetsuNyushoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiShisetsuNyushoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiShisetsuNyushoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiShisetsuNyushoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiShisetsuNyushoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiShisetsuNyushoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShisetsuBunrui = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuBunrui"));
            };

            Controls.prototype.txtShisetsuNyushoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShisetsuNyushoYMD"));
            };

            Controls.prototype.txtShisetsuTaishoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShisetsuTaishoYMD"));
            };

            Controls.prototype.txtShisetsuName = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuName"));
            };

            Controls.prototype.txtShisetsuJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuJigyoshaNo"));
            };

            Controls.prototype.txtShisetsuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuJigyoshaName"));
            };

            Controls.prototype.txtShisetsuJigyoshaJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuJigyoshaJusho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiShisetsuNyushoInfo.Controls = Controls;
    })(DBZ.SogoShokaiShisetsuNyushoInfo || (DBZ.SogoShokaiShisetsuNyushoInfo = {}));
    var SogoShokaiShisetsuNyushoInfo = DBZ.SogoShokaiShisetsuNyushoInfo;
})(DBZ || (DBZ = {}));
