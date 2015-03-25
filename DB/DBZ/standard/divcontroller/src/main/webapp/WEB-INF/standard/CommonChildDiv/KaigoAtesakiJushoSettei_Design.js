var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoSettei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoAtesakiJushoSettei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoAtesakiJushoSettei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoSettei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoAtesakiJushoSettei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoAtesakiJushoSettei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radJushoSettei = function () {
                return new UZA.RadioButton(this.convFiledName("radJushoSettei"));
            };

            Controls.prototype.btnAtesakiJushoSettei = function () {
                return new UZA.Button(this.convFiledName("btnAtesakiJushoSettei"));
            };

            Controls.prototype.txtAtesakiJushoSettei = function () {
                return new UZA.TextBox(this.convFiledName("txtAtesakiJushoSettei"));
            };
            return Controls;
        })();
        KaigoAtesakiJushoSettei.Controls = Controls;
    })(DBZ.KaigoAtesakiJushoSettei || (DBZ.KaigoAtesakiJushoSettei = {}));
    var KaigoAtesakiJushoSettei = DBZ.KaigoAtesakiJushoSettei;
})(DBZ || (DBZ = {}));
