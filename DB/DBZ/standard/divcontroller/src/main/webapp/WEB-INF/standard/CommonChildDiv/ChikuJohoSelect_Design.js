var DBZ;
(function (DBZ) {
    (function (ChikuJohoSelect) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChikuJohoSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChikuJohoSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChikuJohoSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TanitsuShichoson = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson"));
            };

            Controls.prototype.ddlChiku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            };

            Controls.prototype.ddlKyushichosonTanitsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonTanitsu"));
            };

            Controls.prototype.ChoikiSelect = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_ChoikiSelect"));
            };

            Controls.prototype.lblKaraChoiki = function () {
                return new UZA.Label(this.convFiledName("lblKaraChoiki"));
            };

            Controls.prototype.GyoseikuSelect = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_GyoseikuSelect"));
            };

            Controls.prototype.lblKaraGyoseiku = function () {
                return new UZA.Label(this.convFiledName("lblKaraGyoseiku"));
            };

            Controls.prototype.Chikiku1Select = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku1Select"));
            };

            Controls.prototype.lblKaraChiku1 = function () {
                return new UZA.Label(this.convFiledName("lblKaraChiku1"));
            };

            Controls.prototype.Chikiku2Select = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku2Select"));
            };

            Controls.prototype.lblKaraChiku2 = function () {
                return new UZA.Label(this.convFiledName("lblKaraChiku2"));
            };

            Controls.prototype.Chikiku3Select = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku3Select"));
            };

            Controls.prototype.lblKaraChiku3 = function () {
                return new UZA.Label(this.convFiledName("lblKaraChiku3"));
            };

            Controls.prototype.koikiShichoson = function () {
                return new UZA.Panel(this.convFiledName("koikiShichoson"));
            };

            Controls.prototype.ddlShichoson = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShichoson"));
            };

            Controls.prototype.ddlKyushichosonKoiki = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonKoiki"));
            };
            return Controls;
        })();
        ChikuJohoSelect.Controls = Controls;
    })(DBZ.ChikuJohoSelect || (DBZ.ChikuJohoSelect = {}));
    var ChikuJohoSelect = DBZ.ChikuJohoSelect;
})(DBZ || (DBZ = {}));
