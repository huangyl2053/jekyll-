var DBD;
(function (DBD) {
    (function (GemmenGengakuShinsei) {
        var Events = (function () {
            function Events() {
            }
            Events.onclick_txtCopyHonnin = function () {
                return "onclick_txtCopyHonnin";
            };
            return Events;
        })();
        GemmenGengakuShinsei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GemmenGengakuShinsei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.GemmenGengakuShinsei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.GemmenGengakuShinsei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GemmenGengakuShinsei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlShinseiDaikoKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseiDaikoKubun"));
            };

            Controls.prototype.Shinseisha = function () {
                return new UZA.Panel(this.convFiledName("Shinseisha"));
            };

            Controls.prototype.txtShinseishaShimeiKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtShinseishaShimeiKana"));
            };

            Controls.prototype.txtCopyHonnin = function () {
                return new UZA.Button(this.convFiledName("txtCopyHonnin"));
            };

            Controls.prototype.txtShinseishaShimei = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtShinseishaShimei"));
            };

            Controls.prototype.txtShinseishaTsuzukigara = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaTsuzukigara"));
            };

            Controls.prototype.imgYubinNoLabel = function () {
                return new UZA.StaticImage(this.convFiledName("imgYubinNoLabel"));
            };

            Controls.prototype.txtShinseishaYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShinseishaYubinNo"));
            };

            Controls.prototype.txtShinseishaTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtShinseishaTelNo"));
            };

            Controls.prototype.txtShinseishaJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtShinseishaJusho"));
            };

            Controls.prototype.ShinseiDaikoJigyosha = function () {
                return new UZA.Panel(this.convFiledName("ShinseiDaikoJigyosha"));
            };

            Controls.prototype.ddlJigyoshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            };
            return Controls;
        })();
        GemmenGengakuShinsei.Controls = Controls;
    })(DBD.GemmenGengakuShinsei || (DBD.GemmenGengakuShinsei = {}));
    var GemmenGengakuShinsei = DBD.GemmenGengakuShinsei;
})(DBD || (DBD = {}));
