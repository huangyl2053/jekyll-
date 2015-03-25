var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoHenshu) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoAtesakiJushoHenshu.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoAtesakiJushoHenshu";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoHenshu.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoHenshu.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoAtesakiJushoHenshu = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.JushoHenshu1 = function () {
                return new UZA.Panel(this.convFiledName("JushoHenshu1"));
            };

            Controls.prototype.radKenmeiHyojiUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radKenmeiHyojiUmu"));
            };

            Controls.prototype.radGunmeiHyojiUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radGunmeiHyojiUmu"));
            };

            Controls.prototype.radCitymeiHyojiUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radCitymeiHyojiUmu"));
            };

            Controls.prototype.JushoHenshu2 = function () {
                return new UZA.Panel(this.convFiledName("JushoHenshu2"));
            };

            Controls.prototype.ddlJushoHenshu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJushoHenshu"));
            };

            Controls.prototype.radKatagakiHyojiUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radKatagakiHyojiUmu"));
            };

            Controls.prototype.SpaceJusho = function () {
                return new UZA.Space(this.convFiledName("SpaceJusho"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        KaigoAtesakiJushoHenshu.Controls = Controls;
    })(DBZ.KaigoAtesakiJushoHenshu || (DBZ.KaigoAtesakiJushoHenshu = {}));
    var KaigoAtesakiJushoHenshu = DBZ.KaigoAtesakiJushoHenshu;
})(DBZ || (DBZ = {}));
