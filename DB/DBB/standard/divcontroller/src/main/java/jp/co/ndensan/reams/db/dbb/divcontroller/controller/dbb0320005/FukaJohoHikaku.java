/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320005;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.FukaJohoHikakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.HonSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.KariSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005.KariSantei2Div;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.business.viewstate.MaeRirekiKey;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 賦課照会の比較Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukaJohoHikaku {

    /**
     * 初期処理です。
     *
     * @param div 賦課照会比較Div
     * @return レスポンスデータ
     */
    public ResponseData<FukaJohoHikakuDiv> initialize(FukaJohoHikakuDiv div) {

        FukaShokaiKey fukaShokaiKey = FukaShokaiController.getFukaShokaiKeyInViewState();
        MaeRirekiKey maeRirekiKey = FukaShokaiController.getMaeRirekiKeyInViewState();

        FukaHikakuTarget target = checkFukaHikakuTarget(fukaShokaiKey, maeRirekiKey);

        switch (target) {
            case 本算定_仮算定:
                setDivFor本1_仮1(div);
                break;
            case 仮算定_仮算定:
                setDivFor仮1_仮2(div);
                break;
            case 仮算定_本算定:
                setDivFor仮1_本2(div);
                break;
            case 本算定_本算定:
                setDivFor本1_本2(div);
                break;
            default:
        }

        return createResponseData(div);
    }

    private FukaHikakuTarget checkFukaHikakuTarget(FukaShokaiKey fukaShokaiKey, MaeRirekiKey maeRirekiKey) {
        if (fukaShokaiKey.get算定状態() == SanteiState.仮算定 && maeRirekiKey.get算定状態() == SanteiState.仮算定) {
            return FukaHikakuTarget.仮算定_仮算定;
        } else if (fukaShokaiKey.get算定状態() == SanteiState.仮算定 && maeRirekiKey.get算定状態() == SanteiState.本算定) {
            return FukaHikakuTarget.仮算定_本算定;
        } else if (fukaShokaiKey.get算定状態() == SanteiState.本算定 && maeRirekiKey.get算定状態() == SanteiState.本算定) {
            return FukaHikakuTarget.本算定_本算定;
        } else {
            return FukaHikakuTarget.本算定_本算定;
        }
    }

    private enum FukaHikakuTarget {

        本算定_仮算定,
        仮算定_仮算定,
        仮算定_本算定,
        本算定_本算定;
    }

    private void setDivFor本1_仮1(FukaJohoHikakuDiv div) {
        div.getHonSantei1().setDisplayNone(false);
        div.getHonSantei2().setDisplayNone(true);
        div.getKariSantei1().setDisplayNone(false);
        div.getKariSantei2().setDisplayNone(true);

        setHonSantei1(div.getHonSantei1(),
                FukaShokaiController.getFukaModelByFukaShokaiKey(), FukaShokaiController.getFukaShokaiKeyInViewState().get氏名());
        setKariSantei1(div.getKariSantei1(),
                FukaShokaiController.getFukaModelByMaeRirekiKey(), FukaShokaiController.getMaeRirekiKeyInViewState().get氏名());
    }

    private void setDivFor仮1_仮2(FukaJohoHikakuDiv div) {
        div.getHonSantei1().setDisplayNone(true);
        div.getHonSantei2().setDisplayNone(true);
        div.getKariSantei1().setDisplayNone(false);
        div.getKariSantei2().setDisplayNone(false);

        setKariSantei1(div.getKariSantei1(),
                FukaShokaiController.getFukaModelByFukaShokaiKey(), FukaShokaiController.getFukaShokaiKeyInViewState().get氏名());
        setKariSantei2(div.getKariSantei2(),
                FukaShokaiController.getFukaModelByMaeRirekiKey(), FukaShokaiController.getMaeRirekiKeyInViewState().get氏名());
    }

    private void setDivFor仮1_本2(FukaJohoHikakuDiv div) {
        div.getHonSantei1().setDisplayNone(true);
        div.getHonSantei2().setDisplayNone(false);
        div.getKariSantei1().setDisplayNone(false);
        div.getKariSantei2().setDisplayNone(true);

        setKariSantei1(div.getKariSantei1(),
                FukaShokaiController.getFukaModelByFukaShokaiKey(), FukaShokaiController.getFukaShokaiKeyInViewState().get氏名());
        setHonSantei2(div.getHonSantei2(),
                FukaShokaiController.getFukaModelByMaeRirekiKey(), FukaShokaiController.getMaeRirekiKeyInViewState().get氏名());
    }

    private void setDivFor本1_本2(FukaJohoHikakuDiv div) {
        div.getHonSantei1().setDisplayNone(false);
        div.getHonSantei2().setDisplayNone(false);
        div.getKariSantei1().setDisplayNone(true);
        div.getKariSantei2().setDisplayNone(true);

        setHonSantei1(div.getHonSantei1(),
                FukaShokaiController.getFukaModelByFukaShokaiKey(), FukaShokaiController.getFukaShokaiKeyInViewState().get氏名());
        setHonSantei2(div.getHonSantei2(),
                FukaShokaiController.getFukaModelByMaeRirekiKey(), FukaShokaiController.getMaeRirekiKeyInViewState().get氏名());
    }

    private void clearKariSantei1(final KariSantei1Div div) {
        div.getTxtChoteiJiyuKari11().clearValue();
        div.getTxtChoteiJiyuKari14().clearValue();
        div.getTxtFukaNendoKari1().clearDomain();
        div.getTxtGemmenGakuKari1().clearValue();
        div.getTxtHokenryoRitsuKari1().clearValue();
        div.getTxtChoteiJiyuKari13().clearValue();
        div.getTxtKoseiYMDKari1().clearValue();
        div.getTxtHokenryoDankaiKari1().clearValue();
        div.getTxtShimeiKari1().clearValue();
        div.getTxtKoseiYMKari1().clearValue();
        div.getTxtZanteiGoukeiGakuKari1().clearValue();
        div.getTxtTsuchiNoKari1().clearValue();
        div.getTxtShikakuSoshitsuYMDKari1().clearValue();
        div.getTxtChoteiJiyuKari12().clearValue();
        div.getTxtZanteiKeisanjoHokenryoKari1().clearValue();
        div.getTxtChoteiNendoKari1().clearDomain();
        div.getTxtNengakuHokenryoKari1().clearValue();
        div.getTxtShikakuShutokuYMDKari1().clearValue();
    }

    private void clearKariSantei2(final KariSantei2Div div) {
        div.getTxtChoteiJiyuKari23().clearValue();
        div.getTxtShikakuSoshitsuYMDKari2().clearValue();
        div.getTxtGemmenGakuKari2().clearValue();
        div.getTxtFukaNendoKari2().clearDomain();
        div.getTxtKoseiYMDKari2().clearValue();
        div.getTxtZanteiKeisanjoHokenryoKari2().clearValue();
        div.getTxtTsuchiNoKari2().clearValue();
        div.getTxtHokenryoRitsuKari2().clearValue();
        div.getTxtChoteiJiyuKari22().clearValue();
        div.getTxtShimeiKari2().clearValue();
        div.getTxtNengakuHokenryoKari2().clearValue();
        div.getTxtChoteiNendoKari2().clearDomain();
        div.getTxtChoteiJiyuKari21().clearValue();
        div.getTxtZanteiGoukeiGakuKari2().clearValue();
        div.getTxtShikakuShutokuYMDKari2().clearValue();
        div.getTxtChoteiJiyuKari24().clearValue();
        div.getTxtKoseiYMKari2().clearValue();
        div.getTxtHokenryoDankaiKari2().clearValue();
    }

    private void clearHonSantei1(final HonSantei1Div div) {
        div.getTxtKyokaisoHon1().clearValue();
        div.getTxtHokenryoDankaiHon1().clearValue();
        div.getTxtChoteiNendoHon1().clearDomain();
        div.getTxtKakuteiHokenryoHon1().clearValue();
        div.getTxtChoteiJiyuHon13().clearValue();
        div.getTxtShimeiHon1().clearValue();
        div.getTxtNenkinShunyuHon1().clearValue();
        div.getTxtGemmenGakuHon1().clearValue();
        div.getTxtShikakusoshitsuYMDHon1().clearValue();
        div.getTxtFukaNendoHon1().clearDomain();
        div.getTxtShikakuShutokuYMDHon1().clearValue();
        div.getTxtSetaiinSuHon1().clearValue();
        div.getTxtChoteiJiyuHon14().clearValue();
        div.getTxtKoseiYMDHon1().clearValue();
        div.getTxtGoukeiShotokuHon1().clearValue();
        div.getTxtChoteiJiyuHon12().clearValue();
        div.getTxtHonninKazeiHon1().clearValue();
        div.getTxtKeisanHokenryogakuHon1().clearValue();
        div.getTxtSetaiKazeiHon1().clearValue();
        div.getTxtKoseiYMHon1().clearValue();
        div.getTxtTsuchiNoHon1().clearValue();
        div.getTxtChoteiJiyuHon11().clearValue();
    }

    private void clearHonSantei2(final HonSantei2Div div) {
        div.getTxtKeisanHokenryogakuHon2().clearValue();
        div.getTxtHonninKazeiHon2().clearValue();
        div.getTxtSetaiKazeiHon2().clearValue();
        div.getTxtChoteiJiyuHon23().clearValue();
        div.getTxtKoseiYMDHon2().clearValue();
        div.getTxtTsuchiNoHon2().clearValue();
        div.getTxtKoseiYMHon2().clearValue();
        div.getTxtGoukeiShotokuHon2().clearValue();
        div.getTxtShikakuSoshitsuYMDHon2().clearValue();
        div.getTxtChoteiJiyuHon22().clearValue();
        div.getTxtNenkinShunyuHon2().clearValue();
        div.getTxtShimeiHon2().clearValue();
        div.getTxtShikakuShutokuYMDHon2().clearValue();
        div.getTxtKyokaisoHon2().clearValue();
        div.getTxtKakuteiHokenryoHon2().clearValue();
        div.getTxtChoteiJiyuHon24().clearValue();
        div.getTxtSetaiinSuHon2().clearValue();
        div.getTxtHokenryoDankaiHon2().clearValue();
        div.getTxtGemmenGakuHon2().clearValue();
        div.getTxtChoteiJiyuHon21().clearValue();
        div.getTxtFukaNendoHon2().clearDomain();
        div.getTxtChoteiNendoHon2().clearDomain();
    }

    private void setKariSantei1(final KariSantei1Div div, FukaModel model, AtenaMeisho name) {
        clearKariSantei1(div);

        div.getTxtChoteiJiyuKari11().setValue(model.get調定事由1().getRyakusho());
        div.getTxtChoteiJiyuKari14().setValue(model.get調定事由4().getRyakusho());
        div.getTxtFukaNendoKari1().setDomain(FukaMapper.toRYear(model.get賦課年度().value()));
        div.getTxtGemmenGakuKari1().setValue(model.get減免額());

        IOptional<HokenryoDankai> 前年度保険料段階 = FukaShokaiController.findZennendoHokenryoDankai(model);
        if (前年度保険料段階.isPresent()) {
            div.getTxtHokenryoDankaiKari1().setValue(前年度保険料段階.get().edit表示用保険料段階());
            div.getTxtHokenryoRitsuKari1().setValue(FukaMapper.toRString(前年度保険料段階.get().get保険料率()));
        }

        div.getTxtChoteiJiyuKari13().setValue(model.get調定事由3().getRyakusho());
        div.getTxtKoseiYMDKari1().setValue(model.get調定日時().getDate().wareki().toDateString());
        div.getTxtKoseiTimeKari1().setValue(model.get調定日時().getTime());
        div.getKibetsugakuKari1().getCcdKiwarigakuKari1().
                load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());

        div.getTxtShimeiKari1().setValue(name.value());
        div.getTxtKoseiYMKari1().setValue(model.get更正月());
        div.getTxtZanteiGoukeiGakuKari1().setValue(model.get確定介護保険料_年額());
        div.getTxtTsuchiNoKari1().setValue(model.get通知書番号().value());
        div.getTxtShikakuSoshitsuYMDKari1().setValue(FukaMapper.toRDate(model.get資格喪失日()));
        div.getTxtChoteiJiyuKari12().setValue(model.get調定事由2().getRyakusho());
        div.getTxtZanteiKeisanjoHokenryoKari1().setValue(model.get減免前介護保険料_年額());
        div.getTxtChoteiNendoKari1().setDomain(FukaMapper.toRYear(model.get調定年度().value()));
        div.getTxtNengakuHokenryoKari1().setValue(model.get確定介護保険料_年額());
        div.getTxtShikakuShutokuYMDKari1().setValue(FukaMapper.toRDate(model.get資格取得日()));
    }

    private void setKariSantei2(final KariSantei2Div div, FukaModel model, AtenaMeisho name) {
        clearKariSantei2(div);

        div.getTxtChoteiJiyuKari23().setValue(model.get調定事由3().getRyakusho());
        div.getTxtShikakuSoshitsuYMDKari2().setValue(FukaMapper.toRDate(model.get資格喪失日()));
        div.getTxtGemmenGakuKari2().setValue(model.get減免額());
        div.getTxtFukaNendoKari2().setDomain(FukaMapper.toRYear(model.get賦課年度().value()));
        div.getTxtKoseiYMDKari2().setValue(model.get調定日時().getDate().wareki().toDateString());
        div.getTxtKoseiTimeKari2().setValue(model.get調定日時().getTime());
        div.getTxtZanteiKeisanjoHokenryoKari2().setValue(model.get減免前介護保険料_年額());
        div.getTxtTsuchiNoKari2().setValue(model.get通知書番号().value());
        div.getTxtChoteiJiyuKari22().setValue(model.get調定事由2().getRyakusho());
        div.getTxtShimeiKari2().setValue(name.value());
        div.getTxtNengakuHokenryoKari2().setValue(model.get確定介護保険料_年額());
        div.getTxtChoteiNendoKari2().setDomain(FukaMapper.toRYear(model.get調定年度().value()));
        div.getTxtChoteiJiyuKari21().setValue(model.get調定事由1().getRyakusho());
        div.getTxtZanteiGoukeiGakuKari2().setValue(model.get確定介護保険料_年額());
        div.getTxtShikakuShutokuYMDKari2().setValue(FukaMapper.toRDate(model.get資格取得日()));
        div.getTxtChoteiJiyuKari24().setValue(model.get調定事由4().getRyakusho());
        div.getTxtKoseiYMKari2().setValue(model.get更正月());
        div.getKibetsugakuKari2().getCcdKiwarigakuKari2().
                load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());

        IOptional<HokenryoDankai> 前年度保険料段階 = FukaShokaiController.findZennendoHokenryoDankai(model);
        if (前年度保険料段階.isPresent()) {
            div.getTxtHokenryoDankaiKari2().setValue(前年度保険料段階.get().edit表示用保険料段階());
            div.getTxtHokenryoRitsuKari2().setValue(FukaMapper.toRString(前年度保険料段階.get().get保険料率()));
        }
    }

    private void setHonSantei1(final HonSantei1Div div, FukaModel model, AtenaMeisho name) {
        clearHonSantei1(div);

        div.getTxtKyokaisoHon1().setValue(model.get境界層区分().toRString());
        div.getTxtHokenryoDankaiHon1().setValue(
                FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料段階())
                .edit表示用保険料段階());
        div.getTxtChoteiNendoHon1().setDomain(FukaMapper.toRYear(model.get調定年度().value()));
        div.getTxtKakuteiHokenryoHon1().setValue(model.get確定介護保険料_年額());
        div.getTxtChoteiJiyuHon13().setValue(model.get調定事由3().getRyakusho());
        div.getTxtShimeiHon1().setValue(name.value());
        div.getTxtNenkinShunyuHon1().setValue(model.get公的年金収入額());
        div.getTxtGemmenGakuHon1().setValue(model.get減免額());
        div.getTxtShikakusoshitsuYMDHon1().setValue(FukaMapper.toRDate(model.get資格喪失日()));
        div.getTxtFukaNendoHon1().setDomain(FukaMapper.toRYear(model.get賦課年度().value()));
        div.getKibetsugakuHon1().getCcdKiwarigakuHon1().
                load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());
        div.getTxtShikakuShutokuYMDHon1().setValue(FukaMapper.toRDate(model.get資格取得日()));
        div.getTxtSetaiinSuHon1().setValue(FukaMapper.toRString(model.get世帯員数()));
        div.getTxtChoteiJiyuHon14().setValue(model.get調定事由4().getRyakusho());
        div.getTxtKoseiYMDHon1().setValue(model.get調定日時().getDate().wareki().toDateString());
        div.getTxtKoseiTimeHon1().setValue(model.get調定日時().getTime());
        div.getTxtGoukeiShotokuHon1().setValue(model.get合計所得金額());
        div.getTxtChoteiJiyuHon12().setValue(model.get調定事由2().getRyakusho());
        div.getTxtHonninKazeiHon1().setValue(model.get課税区分().toRString());
        div.getTxtKeisanHokenryogakuHon1().setValue(model.get減免前介護保険料_年額());
        div.getTxtSetaiKazeiHon1().setValue(model.get世帯課税区分().toRString());
        div.getTxtKoseiYMHon1().setValue(model.get更正月());
        div.getTxtTsuchiNoHon1().setValue(model.get通知書番号().value());
        div.getTxtChoteiJiyuHon11().setValue(model.get調定事由1().getRyakusho());
    }

    private void setHonSantei2(final HonSantei2Div div, FukaModel model, AtenaMeisho name) {
        clearHonSantei2(div);

        div.getTxtKeisanHokenryogakuHon2().setValue(model.get減免前介護保険料_年額());
        div.getTxtHonninKazeiHon2().setValue(model.get課税区分().toRString());
        div.getTxtSetaiKazeiHon2().setValue(model.get世帯課税区分().toRString());
        div.getTxtChoteiJiyuHon23().setValue(model.get調定事由3().getRyakusho());
        div.getTxtKoseiYMDHon2().setValue(model.get調定日時().getDate().wareki().toDateString());
        div.getTxtKoseiTimeHon2().setValue(model.get調定日時().getTime());
        div.getTxtTsuchiNoHon2().setValue(model.get通知書番号().value());
        div.getTxtKoseiYMHon2().setValue(model.get更正月());
        div.getTxtGoukeiShotokuHon2().setValue(model.get合計所得金額());
        div.getTxtShikakuSoshitsuYMDHon2().setValue(FukaMapper.toRDate(model.get資格喪失日()));
        div.getTxtChoteiJiyuHon22().setValue(model.get調定事由2().getRyakusho());
        div.getTxtNenkinShunyuHon2().setValue(model.get公的年金収入額());
        div.getTxtShimeiHon2().setValue(name.value());
        div.getTxtShikakuShutokuYMDHon2().setValue(FukaMapper.toRDate(model.get資格取得日()));
        div.getTxtKyokaisoHon2().setValue(model.get境界層区分().toRString());
        div.getKibetsugakuHon2().getCcdKiwarigakuHon2().
                load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get処理日時());
        div.getTxtKakuteiHokenryoHon2().setValue(model.get確定介護保険料_年額());
        div.getTxtChoteiJiyuHon24().setValue(model.get調定事由4().getRyakusho());
        div.getTxtSetaiinSuHon2().setValue(FukaMapper.toRString(model.get世帯員数()));
        div.getTxtHokenryoDankaiHon2().setValue(
                FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料段階())
                .edit表示用保険料段階());
        div.getTxtGemmenGakuHon2().setValue(model.get減免額());
        div.getTxtChoteiJiyuHon21().setValue(model.get調定事由1().getRyakusho());
        div.getTxtFukaNendoHon2().setDomain(FukaMapper.toRYear(model.get賦課年度().value()));
        div.getTxtChoteiNendoHon2().setDomain(FukaMapper.toRYear(model.get調定年度().value()));
    }

    private ResponseData<FukaJohoHikakuDiv> createResponseData(FukaJohoHikakuDiv div) {
        ResponseData<FukaJohoHikakuDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
