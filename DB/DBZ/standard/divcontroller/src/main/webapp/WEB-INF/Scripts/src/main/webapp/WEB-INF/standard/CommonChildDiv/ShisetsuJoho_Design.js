var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShisetsuShurui = function () {
                return "onChange_radShisetsuShurui";
            };
            return Events;
        })();
        ShisetsuJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlDaichoShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            };

            Controls.prototype.radShisetsuShurui = function () {
                return new UZA.RadioButton(this.convFiledName("radShisetsuShurui"));
            };

            Controls.prototype.txtShisetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnOtherTokureiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOtherTokureiShisetsuInputGuide"));
            };

            Controls.prototype.btnJogaiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJogaiShisetsuInputGuide"));
            };

            Controls.prototype.txtShisetsuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuMeisho"));
            };
            return Controls;
        })();
        ShisetsuJoho.Controls = Controls;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
