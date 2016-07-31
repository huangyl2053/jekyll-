/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.util.HokenryoDankaiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import static jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.DecorationUtil.decorateBothIfDifferentNum;
import static jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.DecorationUtil.decorateBothIfDifferentRDate;
import static jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.DecorationUtil.decorateBothIfDifferentString;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320005.input.FukaHikakuTargets;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.FukaJohoHikakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.HonSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.HonSantei2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.KariSantei1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320005.KariSantei2Div;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課比較の画面描画に関連するオブジェクトを管理します。
 */
public final class FukaJohoHikakuPresenter {

    private FukaJohoHikakuPresenter() {
    }

    /**
     * 賦課比較の画面描画に関連する処理を行うオブジェクトであることを表します。
     */
    public interface IFukaHikakuPresenter {

        /**
         * 比較対象を描画します。
         *
         * @param div 賦課比較
         */
        void presentComparingValues(FukaJohoHikakuDiv div);
    }

    private static RDate toRDate(FlexibleDate flexibleDate) {
        return FukaMapper.toRDate(flexibleDate);
    }

    private static AtenaMeisho search氏名(ShikibetsuCode shikibetsuCode) {
        List<IKojin> searchResult = ShikibetsuTaishoService.getKojinFinder().get個人s(
                new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先))
                .set識別コード(shikibetsuCode)
                .build()
        );
        if (searchResult.isEmpty()) {
            return AtenaMeisho.EMPTY;
        } else {
            IKojin kojin = searchResult.get(0);
            if (kojin.is外国人()) {
                return kojin.get外国人氏名().getName();
            }
            return kojin.get日本人氏名().getName();
        }
    }

    private abstract static class FukaJohoHikakuPresenterHelper implements IFukaHikakuPresenter {

        protected void decorateDifferentValues(KariSantei1Div div1, KariSantei2Div div2) {
            /* 賦課基準 */
            decorateBothIfDifferentRDate(div1.getTxtShikakuShutokuYMDKari1(), div2.getTxtShikakuShutokuYMDKari2());
            decorateBothIfDifferentRDate(div1.getTxtShikakuSoshitsuYMDKari1(), div2.getTxtShikakuSoshitsuYMDKari2());
            /* 前年度情報 */
//TODO 以下にも処理が必要かどうかを確認する。
//            decorateBothIfDifferentString(div1.getTxtHokenryoDankaiKari1(), div2.getTxtHokenryoDankaiKari2());
//            decorateBothIfDifferentString(div1.getTxtHokenryoRitsuKari1(), div2.getTxtHokenryoRitsuKari2());
//            decorateBothIfDifferentNum(div1.getTxtNengakuHokenryoKari1(), div2.getTxtNengakuHokenryoKari2());
            /* 暫定保険料額 */
            decorateBothIfDifferentNum(div1.getTxtZanteiKeisanjoHokenryoKari1(), div2.getTxtZanteiKeisanjoHokenryoKari2());
            decorateBothIfDifferentNum(div1.getTxtGemmenGakuKari1(), div2.getTxtGemmenGakuKari2());
            decorateBothIfDifferentNum(div1.getTxtZanteiGoukeiGakuKari1(), div2.getTxtZanteiGoukeiGakuKari2());
        }

        protected void decorateDifferentValues(HonSantei1Div div1, KariSantei1Div div2) {
            /* 賦課基準 */
            decorateBothIfDifferentRDate(div1.getTxtShikakuShutokuYMDHon1(), div2.getTxtShikakuShutokuYMDKari1());
            decorateBothIfDifferentRDate(div1.getTxtShikakusoshitsuYMDHon1(), div2.getTxtShikakuSoshitsuYMDKari1());
            /* 保険料額 */
            decorateBothIfDifferentNum(div1.getTxtKeisanHokenryogakuHon1(), div2.getTxtZanteiKeisanjoHokenryoKari1());
            decorateBothIfDifferentNum(div1.getTxtGemmenGakuHon1(), div2.getTxtGemmenGakuKari1());
            decorateBothIfDifferentNum(div1.getTxtKakuteiHokenryoHon1(), div2.getTxtZanteiGoukeiGakuKari1());
        }

        protected void decorateDifferentValues(KariSantei1Div div1, HonSantei2Div div2) {
            /* 賦課基準 */
            decorateBothIfDifferentRDate(div1.getTxtShikakuShutokuYMDKari1(), div2.getTxtShikakuShutokuYMDHon2());
            decorateBothIfDifferentRDate(div1.getTxtShikakuSoshitsuYMDKari1(), div2.getTxtShikakuSoshitsuYMDHon2());
            /* 保険料額 */
            decorateBothIfDifferentNum(div1.getTxtZanteiKeisanjoHokenryoKari1(), div2.getTxtKeisanHokenryogakuHon2());
            decorateBothIfDifferentNum(div1.getTxtGemmenGakuKari1(), div2.getTxtGemmenGakuHon2());
            decorateBothIfDifferentNum(div1.getTxtZanteiGoukeiGakuKari1(), div2.getTxtKakuteiHokenryoHon2());
        }

        protected void decorateDifferentValues(HonSantei1Div div1, KariSantei2Div div2) {
            /* 賦課基準 */
            decorateBothIfDifferentRDate(div1.getTxtShikakuShutokuYMDHon1(), div2.getTxtShikakuShutokuYMDKari2());
            decorateBothIfDifferentRDate(div1.getTxtShikakusoshitsuYMDHon1(), div2.getTxtShikakuSoshitsuYMDKari2());
            /* 保険料額 */
            decorateBothIfDifferentNum(div1.getTxtKeisanHokenryogakuHon1(), div2.getTxtZanteiKeisanjoHokenryoKari2());
            decorateBothIfDifferentNum(div1.getTxtGemmenGakuHon1(), div2.getTxtGemmenGakuKari2());
            decorateBothIfDifferentNum(div1.getTxtKakuteiHokenryoHon1(), div2.getTxtZanteiGoukeiGakuKari2());
        }

        protected void decorateDifferentValues(HonSantei1Div div1, HonSantei2Div div2) {
            /* 賦課基準 */
            decorateBothIfDifferentRDate(div1.getTxtShikakuShutokuYMDHon1(), div2.getTxtShikakuShutokuYMDHon2());
            decorateBothIfDifferentRDate(div1.getTxtShikakusoshitsuYMDHon1(), div2.getTxtShikakuSoshitsuYMDHon2());
            decorateBothIfDifferentNum(div1.getTxtGoukeiShotokuHon1(), div2.getTxtGoukeiShotokuHon2());
            decorateBothIfDifferentNum(div1.getTxtNenkinShunyuHon1(), div2.getTxtNenkinShunyuHon2());
            decorateBothIfDifferentString(div1.getTxtHonninKazeiHon1(), div2.getTxtHonninKazeiHon2());
            decorateBothIfDifferentString(div1.getTxtSetaiKazeiHon1(), div2.getTxtSetaiKazeiHon2());
            decorateBothIfDifferentString(div1.getTxtSetaiinSuHon1(), div2.getTxtSetaiinSuHon2());
            /* 保険料額 */
            decorateBothIfDifferentString(div1.getTxtHokenryoDankaiHon1(), div2.getTxtHokenryoDankaiHon2());
            decorateBothIfDifferentString(div1.getTxtKyokaisoHon1(), div2.getTxtKyokaisoHon2());
            decorateBothIfDifferentNum(div1.getTxtKeisanHokenryogakuHon1(), div2.getTxtKeisanHokenryogakuHon2());
            decorateBothIfDifferentNum(div1.getTxtGemmenGakuHon1(), div2.getTxtGemmenGakuHon2());
            decorateBothIfDifferentNum(div1.getTxtKakuteiHokenryoHon1(), div2.getTxtKakuteiHokenryoHon2());
        }

        protected void clearKariSantei1(final KariSantei1Div div) {
            div.getTxtShimeiKari1().clearValue();
            div.getTxtHokenryoRitsuKari1().clearValue();
            div.getTxtChoteiJiyuKari11().clearValue();
            div.getTxtChoteiJiyuKari12().clearValue();
            div.getTxtChoteiJiyuKari13().clearValue();
            div.getTxtChoteiJiyuKari14().clearValue();
            div.getTxtFukaNendoKari1().clearDomain();
            div.getTxtGemmenGakuKari1().clearValue();
            div.getTxtKoseiYMKari1().clearValue();
            div.getTxtKoseiYMDKari1().clearValue();
            div.getTxtHokenryoDankaiKari1().clearValue();
            div.getTxtShikakuShutokuYMDKari1().clearValue();
            div.getTxtShikakuSoshitsuYMDKari1().clearValue();
            div.getTxtZanteiGoukeiGakuKari1().clearValue();
            div.getTxtZanteiKeisanjoHokenryoKari1().clearValue();
            div.getTxtTsuchiNoKari1().clearValue();
            div.getTxtChoteiNendoKari1().clearDomain();
            div.getTxtNengakuHokenryoKari1().clearValue();
        }

        protected void setKariSantei1(final KariSantei1Div div, Fuka model) {
            clearKariSantei1(div);
            div.getTxtShimeiKari1().setValue(search氏名(model.get識別コード()).value());

            div.getTxtChoteiNendoKari1().setDomain(model.get調定年度());
            div.getTxtFukaNendoKari1().setDomain(model.get賦課年度());
            div.getTxtTsuchiNoKari1().setValue(model.get通知書番号().value());
            div.getTxtShikakuSoshitsuYMDKari1().setValue(toRDate(model.get資格喪失日()));
            div.getTxtShikakuShutokuYMDKari1().setValue(toRDate(model.get資格取得日()));
            div.getTxtKoseiYMDKari1().setValue(model.get調定日時().getDate().wareki().toDateString());
            div.getTxtKoseiTimeKari1().setValue(model.get調定日時().getRDateTime().getTime());
            if (model.get調定事由1() != null) {
                div.getTxtChoteiJiyuKari11().setValue(model.get調定事由1().getRyakusho());
            }
            if (model.get調定事由2() != null) {
                div.getTxtChoteiJiyuKari12().setValue(model.get調定事由2().getRyakusho());
            }
            if (model.get調定事由3() != null) {
                div.getTxtChoteiJiyuKari13().setValue(model.get調定事由3().getRyakusho());
            }
            if (model.get調定事由4() != null) {
                div.getTxtChoteiJiyuKari14().setValue(model.get調定事由4().getRyakusho());
            }
            div.getTxtKoseiYMKari1().setValue(model.get更正月());
            div.getTxtZanteiKeisanjoHokenryoKari1().setValue(model.get減免前介護保険料_年額());
            div.getTxtGemmenGakuKari1().setValue(model.get減免額());
            div.getTxtNengakuHokenryoKari1().setValue(model.get確定介護保険料_年額());
            div.getTxtZanteiGoukeiGakuKari1().setValue(model.get確定介護保険料_年額());

            div.getKibetsugakuKari1().getCcdKiwarigakuKari1().
                    load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), new Decimal(model.get履歴番号()));
            Optional<HokenryoDankai> 前年度保険料段階 = FukaShokaiController.findZennendoHokenryoDankai(model);
            if (前年度保険料段階.isPresent()) {
                div.getTxtHokenryoDankaiKari1().setValue(HokenryoDankaiUtil.edit表示用保険料段階(前年度保険料段階.get()));
                div.getTxtHokenryoRitsuKari1().setValue(FukaMapper.toRString(前年度保険料段階.get().get保険料率()));
            }
        }

        protected void clearKariSantei2(final KariSantei2Div div) {
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

        protected void setKariSantei2(final KariSantei2Div div, Fuka model) {
            clearKariSantei2(div);
            div.getTxtShimeiKari2().setValue(search氏名(model.get識別コード()).value());

            div.getTxtChoteiNendoKari2().setDomain(model.get調定年度());
            div.getTxtFukaNendoKari2().setDomain(model.get賦課年度());
            div.getTxtTsuchiNoKari2().setValue(model.get通知書番号().value());
            div.getTxtShikakuShutokuYMDKari2().setValue(toRDate(model.get資格取得日()));
            div.getTxtShikakuSoshitsuYMDKari2().setValue(toRDate(model.get資格喪失日()));
            div.getTxtKoseiYMDKari2().setValue(model.get調定日時().getDate().wareki().toDateString());
            div.getTxtKoseiTimeKari2().setValue(model.get調定日時().getRDateTime().getTime());
            if (model.get調定事由1() != null) {
                div.getTxtChoteiJiyuKari21().setValue(model.get調定事由1().getRyakusho());
            }
            if (model.get調定事由2() != null) {
                div.getTxtChoteiJiyuKari22().setValue(model.get調定事由2().getRyakusho());
            }
            if (model.get調定事由3() != null) {
                div.getTxtChoteiJiyuKari23().setValue(model.get調定事由3().getRyakusho());
            }
            if (model.get調定事由4() != null) {
                div.getTxtChoteiJiyuKari24().setValue(model.get調定事由4().getRyakusho());
            }
            div.getTxtKoseiYMKari2().setValue(model.get更正月());
            div.getTxtZanteiKeisanjoHokenryoKari2().setValue(model.get減免前介護保険料_年額());
            div.getTxtGemmenGakuKari2().setValue(model.get減免額());
            div.getTxtNengakuHokenryoKari2().setValue(model.get確定介護保険料_年額());
            div.getTxtZanteiGoukeiGakuKari2().setValue(model.get確定介護保険料_年額());

            div.getKibetsugakuKari2().getCcdKiwarigakuKari2().
                    load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), new Decimal(model.get履歴番号()));
            Optional<HokenryoDankai> 前年度保険料段階 = FukaShokaiController.findZennendoHokenryoDankai(model);
            if (前年度保険料段階.isPresent()) {
                div.getTxtHokenryoDankaiKari2().setValue(HokenryoDankaiUtil.edit表示用保険料段階(前年度保険料段階.get()));
                div.getTxtHokenryoRitsuKari2().setValue(FukaMapper.toRString(前年度保険料段階.get().get保険料率()));
            }
        }

        protected void clearHonSantei1(final HonSantei1Div div) {
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

        protected void setHonSantei1(final HonSantei1Div div, Fuka model) {
            clearHonSantei1(div);
            div.getTxtShimeiHon1().setValue(search氏名(model.get識別コード()).value());

            div.getTxtChoteiNendoHon1().setDomain(model.get調定年度());
            div.getTxtFukaNendoHon1().setDomain(model.get賦課年度());
            div.getTxtTsuchiNoHon1().setValue(model.get通知書番号().value());
            div.getTxtSetaiinSuHon1().setValue(new RString(String.valueOf(model.get世帯員数())));
            div.getTxtShikakuShutokuYMDHon1().setValue(toRDate(model.get資格取得日()));
            div.getTxtShikakusoshitsuYMDHon1().setValue(toRDate(model.get資格喪失日()));
            div.getTxtHonninKazeiHon1().setValue(model.get課税区分().get名称());
            div.getTxtSetaiKazeiHon1().setValue(model.get世帯課税区分().get名称());
            div.getTxtGoukeiShotokuHon1().setValue(model.get合計所得金額());
            div.getTxtNenkinShunyuHon1().setValue(model.get公的年金収入額());
            div.getTxtKoseiYMDHon1().setValue(model.get調定日時().getDate().wareki().toDateString());
            div.getTxtKoseiTimeHon1().setValue(model.get調定日時().getRDateTime().getTime());
            if (model.get調定事由1() != null) {
                div.getTxtChoteiJiyuHon11().setValue(model.get調定事由1().getRyakusho());
            }
            if (model.get調定事由2() != null) {
                div.getTxtChoteiJiyuHon12().setValue(model.get調定事由2().getRyakusho());
            }
            if (model.get調定事由3() != null) {
                div.getTxtChoteiJiyuHon13().setValue(model.get調定事由3().getRyakusho());
            }
            if (model.get調定事由4() != null) {
                div.getTxtChoteiJiyuHon14().setValue(model.get調定事由4().getRyakusho());
            }
            div.getTxtKoseiYMHon1().setValue(model.get更正月());
            div.getTxtKeisanHokenryogakuHon1().setValue(model.get減免前介護保険料_年額());
            div.getTxtGemmenGakuHon1().setValue(model.get減免額());
            div.getTxtKakuteiHokenryoHon1().setValue(model.get確定介護保険料_年額());
            div.getTxtKyokaisoHon1().setValue(model.get境界層区分().toRString());
            div.getKibetsugakuHon1().getCcdKiwarigakuHon1().
                    load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), new Decimal(model.get履歴番号()));
            div.getTxtHokenryoDankaiHon1().setValue(
                    HokenryoDankaiUtil.edit表示用保険料段階(
                            FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get保険料段階())));
        }

        protected void clearHonSantei2(final HonSantei2Div div) {
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

        protected void setHonSantei2(final HonSantei2Div div, Fuka model) {
            clearHonSantei2(div);
            div.getTxtShimeiHon2().setValue(search氏名(model.get識別コード()).value());

            div.getTxtChoteiNendoHon2().setDomain(model.get調定年度());
            div.getTxtFukaNendoHon2().setDomain(model.get賦課年度());
            div.getTxtTsuchiNoHon2().setValue(model.get通知書番号().value());
            div.getTxtSetaiinSuHon2().setValue(new RString(String.valueOf(model.get世帯員数())));
            div.getTxtShikakuShutokuYMDHon2().setValue(toRDate(model.get資格取得日()));
            div.getTxtShikakuSoshitsuYMDHon2().setValue(toRDate(model.get資格喪失日()));
            div.getTxtHonninKazeiHon2().setValue(model.get課税区分().get名称());
            div.getTxtSetaiKazeiHon2().setValue(model.get世帯課税区分().get名称());
            div.getTxtGoukeiShotokuHon2().setValue(model.get合計所得金額());
            div.getTxtNenkinShunyuHon2().setValue(model.get公的年金収入額());
            div.getTxtKoseiYMDHon2().setValue(model.get調定日時().getDate().wareki().toDateString());
            div.getTxtKoseiTimeHon2().setValue(model.get調定日時().getRDateTime().getTime());
            if (model.get調定事由1() != null) {
                div.getTxtChoteiJiyuHon21().setValue(model.get調定事由1().getRyakusho());
            }
            if (model.get調定事由2() != null) {
                div.getTxtChoteiJiyuHon22().setValue(model.get調定事由2().getRyakusho());
            }
            if (model.get調定事由3() != null) {
                div.getTxtChoteiJiyuHon23().setValue(model.get調定事由3().getRyakusho());
            }
            if (model.get調定事由4() != null) {
                div.getTxtChoteiJiyuHon24().setValue(model.get調定事由4().getRyakusho());
            }
            div.getTxtKoseiYMHon2().setValue(model.get更正月());
            div.getTxtKeisanHokenryogakuHon2().setValue(model.get減免前介護保険料_年額());
            div.getTxtGemmenGakuHon2().setValue(model.get減免額());
            div.getTxtKakuteiHokenryoHon2().setValue(model.get確定介護保険料_年額());
            div.getTxtKyokaisoHon2().setValue(model.get境界層区分().toRString());
            div.getKibetsugakuHon2().getCcdKiwarigakuHon2().
                    load(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), new Decimal(model.get履歴番号()));
            div.getTxtHokenryoDankaiHon2().setValue(
                    HokenryoDankaiUtil.edit表示用保険料段階(
                            FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get保険料段階())));
        }
    }

    private abstract static class FukaJohoHikakuPresenterBase extends FukaJohoHikakuPresenterHelper {

        private final FukaHikakuTargets targets;

        protected FukaJohoHikakuPresenterBase(FukaHikakuTargets targets) {
            this.targets = targets;
        }

        protected FukaHikakuTargets getTagets() {
            return this.targets;
        }

        @Override
        public void presentComparingValues(FukaJohoHikakuDiv div) {
            setDisplayNone(div);
            setComparingValues(div, targets);
        }

        protected abstract void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets);

        protected abstract void setDisplayNone(FukaJohoHikakuDiv div);

    }

    private static class KarisanteiAndKarisantei extends FukaJohoHikakuPresenterBase {

        protected KarisanteiAndKarisantei(FukaHikakuTargets targets) {
            super(targets);
        }

        @Override
        protected void setDisplayNone(FukaJohoHikakuDiv div) {
            div.getHonSantei1().setDisplayNone(true);
            div.getHonSantei2().setDisplayNone(true);
            div.getKariSantei1().setDisplayNone(false);
            div.getKariSantei2().setDisplayNone(false);
        }

        @Override
        protected void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets) {
            this.setKariSantei1(div.getKariSantei1(), targets.get(0));
            this.setKariSantei2(div.getKariSantei2(), targets.get(1));
            this.decorateDifferentValues(div.getKariSantei1(), div.getKariSantei2());
        }
    }

    private static class KarisanteiAndHonsantei extends FukaJohoHikakuPresenterBase {

        protected KarisanteiAndHonsantei(FukaHikakuTargets targets) {
            super(targets);
        }

        @Override
        protected void setDisplayNone(FukaJohoHikakuDiv div) {
            div.getHonSantei1().setDisplayNone(true);
            div.getHonSantei2().setDisplayNone(false);
            div.getKariSantei1().setDisplayNone(false);
            div.getKariSantei2().setDisplayNone(true);
        }

        @Override
        protected void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets) {
            this.setKariSantei1(div.getKariSantei1(), targets.get(0));
            this.setHonSantei2(div.getHonSantei2(), targets.get(1));
            this.decorateDifferentValues(div.getKariSantei1(), div.getHonSantei2());
        }
    }

    private static class HonsanteiAndKarisantei extends FukaJohoHikakuPresenterBase {

        protected HonsanteiAndKarisantei(FukaHikakuTargets targets) {
            super(targets);
        }

        @Override
        public void setDisplayNone(FukaJohoHikakuDiv div) {
            div.getHonSantei1().setDisplayNone(false);
            div.getHonSantei2().setDisplayNone(true);
            div.getKariSantei1().setDisplayNone(false);
            div.getKariSantei2().setDisplayNone(true);
        }

        @Override
        protected void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets) {
            this.setHonSantei1(div.getHonSantei1(), targets.get(0));
            this.setKariSantei1(div.getKariSantei1(), targets.get(1));
            this.decorateDifferentValues(div.getHonSantei1(), div.getKariSantei1());
        }
    }

    private static class HonsanteiAndHonsantei extends FukaJohoHikakuPresenterBase {

        protected HonsanteiAndHonsantei(FukaHikakuTargets targets) {
            super(targets);
        }

        @Override
        public void setDisplayNone(FukaJohoHikakuDiv div) {
            div.getHonSantei1().setDisplayNone(false);
            div.getHonSantei2().setDisplayNone(false);
            div.getKariSantei1().setDisplayNone(true);
            div.getKariSantei2().setDisplayNone(true);
        }

        @Override
        protected void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets) {
            this.setHonSantei1(div.getHonSantei1(), targets.get(0));
            this.setHonSantei2(div.getHonSantei2(), targets.get(1));
            this.decorateDifferentValues(div.getHonSantei1(), div.getHonSantei2());
        }
    }

    private static class NoneToCompare extends FukaJohoHikakuPresenterBase {

        protected NoneToCompare(FukaHikakuTargets targets) {
            super(targets);
        }

        @Override
        protected void setDisplayNone(FukaJohoHikakuDiv div) {
            div.getHonSantei1().setDisplayNone(true);
            div.getHonSantei2().setDisplayNone(true);
            div.getKariSantei1().setDisplayNone(true);
            div.getKariSantei2().setDisplayNone(true);
        }

        @Override
        protected void setComparingValues(FukaJohoHikakuDiv div, FukaHikakuTargets targets) {
        }
    }

    /**
     * {@link IFukaHikakuPresenter}を生成します。指定の{@link FukaHikakuTargets}の状態により処理が変化します。
     *
     *
     * @param targets {@link FukaHikakuTargets}
     * @return {@link IFukaHikakuPresenter}。指定の{@link FukaHikakuTargets}によって処理が変化する。
     */
    public static IFukaHikakuPresenter createInstance(FukaHikakuTargets targets) {
        switch (targets.getSituation()) {
            case 仮算定And仮算定:
                return new KarisanteiAndKarisantei(targets);
            case 仮算定And本算定:
                return new KarisanteiAndHonsantei(targets);
            case 本算定And仮算定:
                return new HonsanteiAndKarisantei(targets);
            case 本算定And本算定:
                return new HonsanteiAndHonsantei(targets);
            default:
                return new NoneToCompare(targets);
        }
    }
}
