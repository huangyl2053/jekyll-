var DBZ;
(function (DBZ) {
    (function (ShikakuKihonJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new ShikakuKihonJoho.Controls(fieldName);
            }
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        ShikakuKihonJoho.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.RenrakusakiNashi = function () {
                    var btnRenrakusaki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = false;
                    btnHihoRireki.displayNone = true;
                    btnNinteiRireki.displayNone = true;
                };

                DisplayType.prototype.HihokenrirekiNashi = function () {
                    var btnRenrakusaki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = true;
                    btnHihoRireki.displayNone = false;
                    btnNinteiRireki.displayNone = true;
                };
                DisplayType.prototype.NinteirirekiNashi = function () {
                    var btnRenrakusaki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki = Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = true;
                    btnHihoRireki.displayNone = true;
                    btnNinteiRireki.displayNone = false;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(ShikakuKihonJoho.Modes || (ShikakuKihonJoho.Modes = {}));
        var Modes = ShikakuKihonJoho.Modes;
    })(DBZ.ShikakuKihonJoho || (DBZ.ShikakuKihonJoho = {}));
    var ShikakuKihonJoho = DBZ.ShikakuKihonJoho;
})(DBZ || (DBZ = {}));
