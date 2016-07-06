/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei;

import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請情報検索受給パラメータクラス。
 *
 * @reamsid_L DBE-1300-150 houtianpeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YouKaiGoNinTeiShinJyuKyuParameter {

    private final boolean isHihokenshaNo;
    private final RString hihokenshaNo;
    private final boolean isShoKisaiHokenshaNo;
    private final RString shoKisaiHokenshaNo;
    private final boolean isShishoCode;
    private final RString shishoCode;
    private final boolean isHihokenshaName;
    private final boolean isJyoKenMae;
    private final RString hihokenshaName;
    private final RString jyoKen;
    private final boolean isJyoKenAto;
    private final boolean isJyoKenBuFun;
    private final boolean isMinashiNigoEtcTaishoFlag;
    private final boolean isNinteiShinseiYMDFrom;
    private final FlexibleDate ninteiShinseiYMDFrom;
    private final boolean isNinteiShinseiYMDTo;
    private final FlexibleDate ninteiShinseiYMDTo;
    private final boolean isSeinengappiYMDFrom;
    private final FlexibleDate seinengappiYMDFrom;
    private final boolean isSeinengappiYMDTo;
    private final FlexibleDate seinengappiYMDTo;
    private final boolean isNinteiShinseiKubunCode;
    private final Code ninteiShinseiKubunCode;
    private final boolean isSeibetsu;
    private final Code seibetsu;
    private final boolean isHihokenshaKubunCode;
    private final RString hihokenshaKubunCode;
    private final boolean isNinteiShinseiHoreiKubunCode;
    private final Code ninteiShinseiHoreiKubunCode;
    private final boolean isShoriJotaiKubun;
    private final Code shoriJotaiKubun;
    private final boolean isYubinNo;
    private final YubinNo yubinNo;
    private final boolean isChikuCode;
    private final ChikuCode chikuCode;
    private final boolean isShisetsuNyushoFlag;
    private final boolean isJigyoshaMeisho;
    private final RString jigyoshaMeisho;
    private final boolean isChosainShimei;
    private final RString chosainShimei;
    private final boolean isChosaJisshiBashoCode;
    private final Code chosaJisshiBashoCode;
    private final boolean isNinteiChosaKubunCode;
    private final Code ninteiChosaKubunCode;
    private final boolean isNinteichosaJisshiYMDFrom;
    private final FlexibleDate ninteichosaJisshiYMDFrom;
    private final boolean isNinteichosaJisshiYMDTo;
    private final FlexibleDate ninteichosaJisshiYMDTo;
    private final boolean isNinchisho;
    private final Code ninchishoNichijoSeiCode;
    private final boolean isShogai;
    private final Code shogaiNichijoJiritsudoCode;
    private final boolean isIryoKikanMeisho;
    private final RString iryoKikanMeisho;
    private final boolean isShujiiName;
    private final RString shujiiName;
    private final boolean isIshiKubunCode;
    private final Code ishiKubunCode;
    private final boolean isIkenshoJuryoYMDFrom;
    private final FlexibleDate ikenshoJuryoYMDFrom;
    private final boolean isIkenshoJuryoYMDTo;
    private final FlexibleDate ikenshoJuryoYMDTo;
    private final boolean isNeTaKiRi;
    private final RString neTaKiRi;
    private final boolean isNiChiDo;
    private final RString niChiDo;
    private final boolean isIchijiHanteiYMDFrom;
    private final FlexibleDate ichijiHanteiYMDFrom;
    private final boolean isIchijiHanteiYMDTo;
    private final FlexibleDate ichijiHanteiYMDTo;
    private final boolean isIchijiHanteiKekkaCode;
    private final Code ichijiHanteiKekkaCode;
    private final boolean isIchiGojiHanteiYMDFrom;
    private final FlexibleDate ichiGojiHanteiYMDFrom;
    private final boolean isIchiGojiHanteiYMDTo;
    private final FlexibleDate ichiGojiHanteiYMDTo;
    private final boolean isIchiGojiHanteiKekkaCode;
    private final Code ichiGojiHanteiKekkaCode;
    private final boolean isNijiHanteiKekkaInputHoho;
    private final Code nijiHanteiKekkaInputHoho;
    private final boolean isNijiHanteiNinteiYukoKikan;
    private final int nijiHanteiNinteiYukoKikan;
    private final boolean isNijiHanteiNinteiYMDFrom;
    private final FlexibleDate nijiHanteiNinteiYMDFrom;
    private final boolean isNijiHanteiNinteiYMDTo;
    private final FlexibleDate nijiHanteiNinteiYMDTo;
    private final boolean isNijiHanteiShuryoYMDFrom;
    private final FlexibleDate nijiHanteiShuryoYMDFrom;
    private final boolean isNijiHanteiShuryoYMDTo;
    private final FlexibleDate nijiHanteiShuryoYMDTo;
    private final boolean isNijiHanteiKekkaInputYMDFrom;
    private final FlexibleDate nijiHanteiKekkaInputYMDFrom;
    private final boolean isNijiHanteiKekkaInputYMDTo;
    private final FlexibleDate nijiHanteiKekkaInputYMDTo;
    private final boolean isShinsakaiKaisaiYMDFrom;
    private final FlexibleDate shinsakaiKaisaiYMDFrom;
    private final boolean isShinsakaiKaisaiYMDTo;
    private final FlexibleDate shinsakaiKaisaiYMDTo;
    private final boolean isShinsakaiKaisaiNoFrom;
    private final RString shinsakaiKaisaiNoFrom;
    private final boolean isShinsakaiKaisaiNoTo;
    private final RString shinsakaiKaisaiNoTo;
    private final boolean isZenkaiJigyoshaMeisho;
    private final RString zenkaiJigyoshaMeisho;
    private final boolean isZenkaiIryoKikanMeisho;
    private final RString zenkaiIryoKikanMeisho;
    private final boolean isZenkaiNijiHanteiKekka;
    private final Code zenkaiNijiHanteiKekka;
    private final boolean isZenkaiNijiHanteiNintei;
    private final int zenkaiNijiHanteiNintei;
    private final boolean isZenkaiYukoKikanStartFrom;
    private final FlexibleDate zenkaiYukoKikanStartFrom;
    private final boolean isZenkaiYukoKikanStartTo;
    private final FlexibleDate zenkaiYukoKikanStartTo;
    private final boolean isGeninShikkanCode;
    private final Code geninShikkanCode;
    private final boolean isNinteiShinseiYMDSystemFrom;
    private final FlexibleDate ninteiShinseiYMDSystemFrom;
    private final boolean isNinteiShinseiYMDSystemTo;
    private final FlexibleDate ninteiShinseiYMDSystemTo;
    private final boolean isKoShiTaiJyo;
    private final Code ninteiShinseiYukoKubunCode;
    private final boolean isIchijiHanteiKanryoYMD;
    private final boolean isNinteiShinseiJohoYMD;
    private final boolean isMaskingKanryoYMD;
    private final boolean isNinteichosaIraiKanryoYMD;
    private final boolean isNinteiShinsakaiWariateYMD;
    private final boolean isIkenshoSakuseiIraiKanryoYMD;
    private final boolean isNinteiShinsakaiKanryoYMD;
    private final boolean isNinteichosaKanryoYMD;
    private final boolean isIkenshoTorokuKanryoYMD;
    private final boolean isCenterSoshinYMD;
    private final boolean isTuChiSyoRi;
    private final int limitCount;

    private YouKaiGoNinTeiShinJyuKyuParameter(
            boolean isHihokenshaNo,
            RString hihokenshaNo,
            boolean isShoKisaiHokenshaNo,
            RString shoKisaiHokenshaNo,
            boolean isShishoCode,
            RString shishoCode,
            boolean isHihokenshaName,
            boolean isJyoKenMae,
            RString hihokenshaName,
            RString jyoKen,
            boolean isJyoKenAto,
            boolean isJyoKenBuFun,
            boolean isMinashiNigoEtcTaishoFlag,
            boolean isNinteiShinseiYMDFrom,
            FlexibleDate ninteiShinseiYMDFrom,
            boolean isNinteiShinseiYMDTo,
            FlexibleDate ninteiShinseiYMDTo,
            boolean isSeinengappiYMDFrom,
            FlexibleDate seinengappiYMDFrom,
            boolean isSeinengappiYMDTo,
            FlexibleDate seinengappiYMDTo,
            boolean isNinteiShinseiKubunCode,
            Code ninteiShinseiKubunCode,
            boolean isSeibetsu,
            Code seibetsu,
            boolean isHihokenshaKubunCode,
            RString hihokenshaKubunCode,
            boolean isNinteiShinseiHoreiKubunCode,
            Code ninteiShinseiHoreiKubunCode,
            boolean isShoriJotaiKubun,
            Code shoriJotaiKubun,
            boolean isYubinNo,
            YubinNo yubinNo,
            boolean isChikuCode,
            ChikuCode chikuCode,
            boolean isShisetsuNyushoFlag,
            boolean isJigyoshaMeisho,
            RString jigyoshaMeisho,
            boolean isChosainShimei,
            RString chosainShimei,
            boolean isChosaJisshiBashoCode,
            Code chosaJisshiBashoCode,
            boolean isNinteiChosaKubunCode,
            Code ninteiChosaKubunCode,
            boolean isNinteichosaJisshiYMDFrom,
            FlexibleDate ninteichosaJisshiYMDFrom,
            boolean isNinteichosaJisshiYMDTo,
            FlexibleDate ninteichosaJisshiYMDTo,
            boolean isNinchisho,
            Code ninchishoNichijoSeiCode,
            boolean isShogai,
            Code shogaiNichijoJiritsudoCode,
            boolean isIryoKikanMeisho,
            RString iryoKikanMeisho,
            boolean isShujiiName,
            RString shujiiName,
            boolean isIshiKubunCode,
            Code ishiKubunCode,
            boolean isIkenshoJuryoYMDFrom,
            FlexibleDate ikenshoJuryoYMDFrom,
            boolean isIkenshoJuryoYMDTo,
            FlexibleDate ikenshoJuryoYMDTo,
            boolean isNeTaKiRi,
            RString neTaKiRi,
            boolean isNiChiDo,
            RString niChiDo,
            boolean isIchijiHanteiYMDFrom,
            FlexibleDate ichijiHanteiYMDFrom,
            boolean isIchijiHanteiYMDTo,
            FlexibleDate ichijiHanteiYMDTo,
            boolean isIchijiHanteiKekkaCode,
            Code ichijiHanteiKekkaCode,
            boolean isIchiGojiHanteiYMDFrom,
            FlexibleDate ichiGojiHanteiYMDFrom,
            boolean isIchiGojiHanteiYMDTo,
            FlexibleDate ichiGojiHanteiYMDTo,
            boolean isIchiGojiHanteiKekkaCode,
            Code ichiGojiHanteiKekkaCode,
            boolean isNijiHanteiKekkaInputHoho,
            Code nijiHanteiKekkaInputHoho,
            boolean isNijiHanteiNinteiYukoKikan,
            int nijiHanteiNinteiYukoKikan,
            boolean isNijiHanteiNinteiYMDFrom,
            FlexibleDate nijiHanteiNinteiYMDFrom,
            boolean isNijiHanteiNinteiYMDTo,
            FlexibleDate nijiHanteiNinteiYMDTo,
            boolean isNijiHanteiShuryoYMDFrom,
            FlexibleDate nijiHanteiShuryoYMDFrom,
            boolean isNijiHanteiShuryoYMDTo,
            FlexibleDate nijiHanteiShuryoYMDTo,
            boolean isNijiHanteiKekkaInputYMDFrom,
            FlexibleDate nijiHanteiKekkaInputYMDFrom,
            boolean isNijiHanteiKekkaInputYMDTo,
            FlexibleDate nijiHanteiKekkaInputYMDTo,
            boolean isShinsakaiKaisaiYMDFrom,
            FlexibleDate shinsakaiKaisaiYMDFrom,
            boolean isShinsakaiKaisaiYMDTo,
            FlexibleDate shinsakaiKaisaiYMDTo,
            boolean isShinsakaiKaisaiNoFrom,
            RString shinsakaiKaisaiNoFrom,
            boolean isShinsakaiKaisaiNoTo,
            RString shinsakaiKaisaiNoTo,
            boolean isZenkaiJigyoshaMeisho,
            RString zenkaiJigyoshaMeisho,
            boolean isZenkaiIryoKikanMeisho,
            RString zenkaiIryoKikanMeisho,
            boolean isZenkaiNijiHanteiKekka,
            Code zenkaiNijiHanteiKekka,
            boolean isZenkaiNijiHanteiNintei,
            int zenkaiNijiHanteiNintei,
            boolean isZenkaiYukoKikanStartFrom,
            FlexibleDate zenkaiYukoKikanStartFrom,
            boolean isZenkaiYukoKikanStartTo,
            FlexibleDate zenkaiYukoKikanStartTo,
            boolean isGeninShikkanCode,
            Code geninShikkanCode,
            boolean isNinteiShinseiYMDSystemFrom,
            FlexibleDate ninteiShinseiYMDSystemFrom,
            boolean isNinteiShinseiYMDSystemTo,
            FlexibleDate ninteiShinseiYMDSystemTo,
            boolean isKoShiTaiJyo,
            Code ninteiShinseiYukoKubunCode,
            boolean isIchijiHanteiKanryoYMD,
            boolean isNinteiShinseiJohoYMD,
            boolean isMaskingKanryoYMD,
            boolean isNinteichosaIraiKanryoYMD,
            boolean isNinteiShinsakaiWariateYMD,
            boolean isIkenshoSakuseiIraiKanryoYMD,
            boolean isNinteiShinsakaiKanryoYMD,
            boolean isNinteichosaKanryoYMD,
            boolean isIkenshoTorokuKanryoYMD,
            boolean isCenterSoshinYMD,
            boolean isTuChiSyoRi,
            int limitCount
    ) {
        this.isHihokenshaNo = isHihokenshaNo;
        this.hihokenshaNo = hihokenshaNo;
        this.isShoKisaiHokenshaNo = isShoKisaiHokenshaNo;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.isShishoCode = isShishoCode;
        this.shishoCode = shishoCode;
        this.isHihokenshaName = isHihokenshaName;
        this.isJyoKenMae = isJyoKenMae;
        this.hihokenshaName = hihokenshaName;
        this.jyoKen = jyoKen;
        this.isJyoKenAto = isJyoKenAto;
        this.isJyoKenBuFun = isJyoKenBuFun;
        this.isMinashiNigoEtcTaishoFlag = isMinashiNigoEtcTaishoFlag;
        this.isNinteiShinseiYMDFrom = isNinteiShinseiYMDFrom;
        this.ninteiShinseiYMDFrom = ninteiShinseiYMDFrom;
        this.isNinteiShinseiYMDTo = isNinteiShinseiYMDTo;
        this.ninteiShinseiYMDTo = ninteiShinseiYMDTo;
        this.isSeinengappiYMDFrom = isSeinengappiYMDFrom;
        this.seinengappiYMDFrom = seinengappiYMDFrom;
        this.isSeinengappiYMDTo = isSeinengappiYMDTo;
        this.seinengappiYMDTo = seinengappiYMDTo;
        this.isNinteiShinseiKubunCode = isNinteiShinseiKubunCode;
        this.ninteiShinseiKubunCode = ninteiShinseiKubunCode;
        this.isSeibetsu = isSeibetsu;
        this.seibetsu = seibetsu;
        this.isHihokenshaKubunCode = isHihokenshaKubunCode;
        this.hihokenshaKubunCode = hihokenshaKubunCode;
        this.isNinteiShinseiHoreiKubunCode = isNinteiShinseiHoreiKubunCode;
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
        this.isShoriJotaiKubun = isShoriJotaiKubun;
        this.shoriJotaiKubun = shoriJotaiKubun;
        this.isYubinNo = isYubinNo;
        this.yubinNo = yubinNo;
        this.isChikuCode = isChikuCode;
        this.chikuCode = chikuCode;
        this.isShisetsuNyushoFlag = isShisetsuNyushoFlag;
        this.isJigyoshaMeisho = isJigyoshaMeisho;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.isChosainShimei = isChosainShimei;
        this.chosainShimei = chosainShimei;
        this.isChosaJisshiBashoCode = isChosaJisshiBashoCode;
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
        this.isNinteiChosaKubunCode = isNinteiChosaKubunCode;
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
        this.isNinteichosaJisshiYMDFrom = isNinteichosaJisshiYMDFrom;
        this.ninteichosaJisshiYMDFrom = ninteichosaJisshiYMDFrom;
        this.isNinteichosaJisshiYMDTo = isNinteichosaJisshiYMDTo;
        this.ninteichosaJisshiYMDTo = ninteichosaJisshiYMDTo;
        this.isNinchisho = isNinchisho;
        this.ninchishoNichijoSeiCode = ninchishoNichijoSeiCode;
        this.isShogai = isShogai;
        this.shogaiNichijoJiritsudoCode = shogaiNichijoJiritsudoCode;
        this.isIryoKikanMeisho = isIryoKikanMeisho;
        this.iryoKikanMeisho = iryoKikanMeisho;
        this.isShujiiName = isShujiiName;
        this.shujiiName = shujiiName;
        this.isIshiKubunCode = isIshiKubunCode;
        this.ishiKubunCode = ishiKubunCode;
        this.isIkenshoJuryoYMDFrom = isIkenshoJuryoYMDFrom;
        this.ikenshoJuryoYMDFrom = ikenshoJuryoYMDFrom;
        this.isIkenshoJuryoYMDTo = isIkenshoJuryoYMDTo;
        this.ikenshoJuryoYMDTo = ikenshoJuryoYMDTo;
        this.isNeTaKiRi = isNeTaKiRi;
        this.neTaKiRi = neTaKiRi;
        this.isNiChiDo = isNiChiDo;
        this.niChiDo = niChiDo;
        this.isIchijiHanteiYMDFrom = isIchijiHanteiYMDFrom;
        this.ichijiHanteiYMDFrom = ichijiHanteiYMDFrom;
        this.isIchijiHanteiYMDTo = isIchijiHanteiYMDTo;
        this.ichijiHanteiYMDTo = ichijiHanteiYMDTo;
        this.isIchijiHanteiKekkaCode = isIchijiHanteiKekkaCode;
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
        this.isIchiGojiHanteiYMDFrom = isIchiGojiHanteiYMDFrom;
        this.ichiGojiHanteiYMDFrom = ichiGojiHanteiYMDFrom;
        this.isIchiGojiHanteiYMDTo = isIchiGojiHanteiYMDTo;
        this.ichiGojiHanteiYMDTo = ichiGojiHanteiYMDTo;
        this.isIchiGojiHanteiKekkaCode = isIchiGojiHanteiKekkaCode;
        this.ichiGojiHanteiKekkaCode = ichiGojiHanteiKekkaCode;
        this.isNijiHanteiKekkaInputHoho = isNijiHanteiKekkaInputHoho;
        this.nijiHanteiKekkaInputHoho = nijiHanteiKekkaInputHoho;
        this.isNijiHanteiNinteiYukoKikan = isNijiHanteiNinteiYukoKikan;
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
        this.isNijiHanteiNinteiYMDFrom = isNijiHanteiNinteiYMDFrom;
        this.nijiHanteiNinteiYMDFrom = nijiHanteiNinteiYMDFrom;
        this.isNijiHanteiNinteiYMDTo = isNijiHanteiNinteiYMDTo;
        this.nijiHanteiNinteiYMDTo = nijiHanteiNinteiYMDTo;
        this.isNijiHanteiShuryoYMDFrom = isNijiHanteiShuryoYMDFrom;
        this.nijiHanteiShuryoYMDFrom = nijiHanteiShuryoYMDFrom;
        this.isNijiHanteiShuryoYMDTo = isNijiHanteiShuryoYMDTo;
        this.nijiHanteiShuryoYMDTo = nijiHanteiShuryoYMDTo;
        this.isNijiHanteiKekkaInputYMDFrom = isNijiHanteiKekkaInputYMDFrom;
        this.nijiHanteiKekkaInputYMDFrom = nijiHanteiKekkaInputYMDFrom;
        this.isNijiHanteiKekkaInputYMDTo = isNijiHanteiKekkaInputYMDTo;
        this.nijiHanteiKekkaInputYMDTo = nijiHanteiKekkaInputYMDTo;
        this.isShinsakaiKaisaiYMDFrom = isShinsakaiKaisaiYMDFrom;
        this.shinsakaiKaisaiYMDFrom = shinsakaiKaisaiYMDFrom;
        this.isShinsakaiKaisaiYMDTo = isShinsakaiKaisaiYMDTo;
        this.shinsakaiKaisaiYMDTo = shinsakaiKaisaiYMDTo;
        this.isShinsakaiKaisaiNoFrom = isShinsakaiKaisaiNoFrom;
        this.shinsakaiKaisaiNoFrom = shinsakaiKaisaiNoFrom;
        this.isShinsakaiKaisaiNoTo = isShinsakaiKaisaiNoTo;
        this.shinsakaiKaisaiNoTo = shinsakaiKaisaiNoTo;
        this.isZenkaiJigyoshaMeisho = isZenkaiJigyoshaMeisho;
        this.zenkaiJigyoshaMeisho = zenkaiJigyoshaMeisho;
        this.isZenkaiIryoKikanMeisho = isZenkaiIryoKikanMeisho;
        this.zenkaiIryoKikanMeisho = zenkaiIryoKikanMeisho;
        this.isZenkaiNijiHanteiKekka = isZenkaiNijiHanteiKekka;
        this.zenkaiNijiHanteiKekka = zenkaiNijiHanteiKekka;
        this.isZenkaiNijiHanteiNintei = isZenkaiNijiHanteiNintei;
        this.zenkaiNijiHanteiNintei = zenkaiNijiHanteiNintei;
        this.isZenkaiYukoKikanStartFrom = isZenkaiYukoKikanStartFrom;
        this.zenkaiYukoKikanStartFrom = zenkaiYukoKikanStartFrom;
        this.isZenkaiYukoKikanStartTo = isZenkaiYukoKikanStartTo;
        this.zenkaiYukoKikanStartTo = zenkaiYukoKikanStartTo;
        this.isGeninShikkanCode = isGeninShikkanCode;
        this.geninShikkanCode = geninShikkanCode;
        this.isNinteiShinseiYMDSystemFrom = isNinteiShinseiYMDSystemFrom;
        this.ninteiShinseiYMDSystemFrom = ninteiShinseiYMDSystemFrom;
        this.isNinteiShinseiYMDSystemTo = isNinteiShinseiYMDSystemTo;
        this.ninteiShinseiYMDSystemTo = ninteiShinseiYMDSystemTo;
        this.isKoShiTaiJyo = isKoShiTaiJyo;
        this.ninteiShinseiYukoKubunCode = ninteiShinseiYukoKubunCode;
        this.isIchijiHanteiKanryoYMD = isIchijiHanteiKanryoYMD;
        this.isNinteiShinseiJohoYMD = isNinteiShinseiJohoYMD;
        this.isMaskingKanryoYMD = isMaskingKanryoYMD;
        this.isNinteichosaIraiKanryoYMD = isNinteichosaIraiKanryoYMD;
        this.isNinteiShinsakaiWariateYMD = isNinteiShinsakaiWariateYMD;
        this.isIkenshoSakuseiIraiKanryoYMD = isIkenshoSakuseiIraiKanryoYMD;
        this.isNinteiShinsakaiKanryoYMD = isNinteiShinsakaiKanryoYMD;
        this.isNinteichosaKanryoYMD = isNinteichosaKanryoYMD;
        this.isIkenshoTorokuKanryoYMD = isIkenshoTorokuKanryoYMD;
        this.isCenterSoshinYMD = isCenterSoshinYMD;
        this.isTuChiSyoRi = isTuChiSyoRi;
        this.limitCount = limitCount;
    }

    /**
     * 共通パラメータ設定。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shoKisaiHokenshaNo 保険者
     * @param shishoCode 支所
     * @param hihokenshaName 被保険者氏名
     * @param jyoKen 条件
     * @param isMinashiNigoEtcTaishoFlag みなし２号申請
     * @param ninteiShinseiYMDFrom 認定申請日From
     * @param ninteiShinseiYMDTo 認定申請日To
     * @param seinengappiYMDFrom 生年月日From
     * @param seinengappiYMDTo 生年月日To
     * @param ninteiShinseiKubunCode 申請区分(申請時)
     * @param hihokenshaKubunCode 被保険者区分
     * @param seibetsu 性別
     * @param ninteiShinseiHoreiKubunCode 申請区分(法令)
     * @param shoriJotaiKubun 処理状態区分
     * @param yubinNo 郵便番号
     * @param chikuCode 地区コード
     * @param isShisetsuNyushoFlag 施設入所
     * @param jigyoshaMeisho 認定調査委託先名称
     * @param chosainShimei 認定調査員氏名
     * @param chosaJisshiBashoCode 調査実施場所
     * @param ninteiChosaKubunCode 調査区分
     * @param ninteichosaJisshiYMDFrom 調査実施日
     * @param ninteichosaJisshiYMDTo 調査実施日
     * @param ninchishoNichijoSeiCode 寝たきり度
     * @param shogaiNichijoJiritsudoCode 認知度
     * @param iryoKikanMeisho 主治医医療機関名称
     * @param shujiiName 主治医氏名
     * @param ishiKubunCode 主治医区分
     * @param ikenshoJuryoYMDFrom 意見受領日From
     * @param ikenshoJuryoYMDTo 意見受領日To
     * @param neTaKiRi 寝たきり度
     * @param niChiDo 認知度
     * @param ichijiHanteiYMDFrom 一次判定日From
     * @param ichijiHanteiYMDTo 一次判定日To
     * @param ichijiHanteiKekkaCode 一次判定結果
     * @param zenkaiJigyoshaMeisho 認定調査委託先
     * @param zenkaiIryoKikanMeisho 主治医医療機関
     * @param zenkaiNijiHanteiKekka 二次判定結果
     * @param zenkaiNijiHanteiNintei 二次判定有効期間
     * @param zenkaiYukoKikanStartFrom 認定有効開始日From
     * @param zenkaiYukoKikanStartTo 認定有効開始日To
     * @param isTuChiSyoRi 通知処理
     * @param limitCount 検索件数
     * @return YouKaiGoNinTeiShinParameter
     */
    public static YouKaiGoNinTeiShinJyuKyuParameter createParam_受給(
            RString hihokenshaNo,
            RString shoKisaiHokenshaNo,
            RString shishoCode,
            RString hihokenshaName,
            RString jyoKen,
            boolean isMinashiNigoEtcTaishoFlag,
            FlexibleDate ninteiShinseiYMDFrom,
            FlexibleDate ninteiShinseiYMDTo,
            FlexibleDate seinengappiYMDFrom,
            FlexibleDate seinengappiYMDTo,
            Code ninteiShinseiKubunCode,
            Code seibetsu,
            RString hihokenshaKubunCode,
            Code ninteiShinseiHoreiKubunCode,
            Code shoriJotaiKubun,
            YubinNo yubinNo,
            ChikuCode chikuCode,
            boolean isShisetsuNyushoFlag,
            RString jigyoshaMeisho,
            RString chosainShimei,
            Code chosaJisshiBashoCode,
            Code ninteiChosaKubunCode,
            FlexibleDate ninteichosaJisshiYMDFrom,
            FlexibleDate ninteichosaJisshiYMDTo,
            Code ninchishoNichijoSeiCode,
            Code shogaiNichijoJiritsudoCode,
            RString iryoKikanMeisho,
            RString shujiiName,
            Code ishiKubunCode,
            FlexibleDate ikenshoJuryoYMDFrom,
            FlexibleDate ikenshoJuryoYMDTo,
            RString neTaKiRi,
            RString niChiDo,
            FlexibleDate ichijiHanteiYMDFrom,
            FlexibleDate ichijiHanteiYMDTo,
            Code ichijiHanteiKekkaCode,
            RString zenkaiJigyoshaMeisho,
            RString zenkaiIryoKikanMeisho,
            Code zenkaiNijiHanteiKekka,
            int zenkaiNijiHanteiNintei,
            FlexibleDate zenkaiYukoKikanStartFrom,
            FlexibleDate zenkaiYukoKikanStartTo,
            boolean isTuChiSyoRi,
            int limitCount
    ) {

        return new YouKaiGoNinTeiShinJyuKyuParameter(
                受給_被保険者番号の判定(false, hihokenshaNo),
                hihokenshaNo,
                受給_保険者の判定(false, shoKisaiHokenshaNo),
                shoKisaiHokenshaNo,
                受給_支所の判定(false, shishoCode),
                shishoCode,
                受給_被保険者氏名の判定(false, hihokenshaName),
                受給_前方一致の判定(false, jyoKen),
                hihokenshaName,
                jyoKen,
                受給_後方一致の判定(false, jyoKen),
                受給_部分一致の判定(false, jyoKen),
                isMinashiNigoEtcTaishoFlag,
                受給_認定申請日Fromの判定(false, ninteiShinseiYMDFrom),
                ninteiShinseiYMDFrom,
                受給_認定申請日Toの判定(false, ninteiShinseiYMDTo),
                ninteiShinseiYMDTo,
                受給_生年月日Fromの判定(false, seinengappiYMDFrom),
                seinengappiYMDFrom,
                受給_生年月日Toの判定(false, seinengappiYMDTo),
                seinengappiYMDTo,
                受給_申請区分_申請時の判定(false, ninteiShinseiKubunCode),
                ninteiShinseiKubunCode,
                受給_性別の判定(false, seibetsu),
                seibetsu,
                受給_被保険者区分の判定(false, hihokenshaKubunCode),
                hihokenshaKubunCode,
                受給_申請区分_法令の判定(false, ninteiShinseiHoreiKubunCode),
                ninteiShinseiHoreiKubunCode,
                受給_処理状態区分の判定(false, shoriJotaiKubun),
                shoriJotaiKubun,
                受給_郵便番号の判定(false, yubinNo),
                yubinNo,
                受給_地区コードの判定(false, chikuCode),
                chikuCode,
                isShisetsuNyushoFlag,
                受給_認定調査委託先名称の判定(false, jigyoshaMeisho),
                jigyoshaMeisho,
                受給_認定調査員氏名の判定(false, chosainShimei),
                chosainShimei,
                受給_調査実施場所の判定(false, chosaJisshiBashoCode),
                chosaJisshiBashoCode,
                受給_調査区分の判定(false, ninteiChosaKubunCode),
                ninteiChosaKubunCode,
                受給_調査実施日Fromの判定(false, ninteichosaJisshiYMDFrom),
                ninteichosaJisshiYMDFrom,
                受給_調査実施日Toの判定(false, ninteichosaJisshiYMDTo),
                ninteichosaJisshiYMDTo,
                受給_寝たきり度の判定(false, ninchishoNichijoSeiCode),
                ninchishoNichijoSeiCode,
                受給_認知度の判定(false, shogaiNichijoJiritsudoCode),
                shogaiNichijoJiritsudoCode,
                受給_主治医医療機関名称の判定(false, iryoKikanMeisho),
                iryoKikanMeisho,
                受給_主治医氏名の判定(false, shujiiName),
                shujiiName,
                受給_主治医区分の判定(false, ishiKubunCode),
                ishiKubunCode,
                受給_意見受領日Fromの判定(false, ikenshoJuryoYMDFrom),
                ikenshoJuryoYMDFrom,
                受給_意見受領日Toの判定(false, ikenshoJuryoYMDTo),
                ikenshoJuryoYMDTo,
                受給_寝たきり度の判定(false, neTaKiRi),
                neTaKiRi,
                受給_認知度の判定(false, niChiDo),
                niChiDo,
                受給_一次判定日Fromの判定(false, ichijiHanteiYMDFrom),
                ichijiHanteiYMDFrom,
                受給_一次判定日Toの判定(false, ichijiHanteiYMDTo),
                ichijiHanteiYMDTo,
                受給_一次判定結果の判定(false, ichijiHanteiKekkaCode),
                ichijiHanteiKekkaCode,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                Code.EMPTY,
                false,
                Code.EMPTY,
                false,
                0,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                RString.EMPTY,
                false,
                RString.EMPTY,
                受給_認定調査委託先の判定(false, zenkaiJigyoshaMeisho),
                zenkaiJigyoshaMeisho,
                受給_主治医医療機関の判定(false, zenkaiIryoKikanMeisho),
                zenkaiIryoKikanMeisho,
                受給_二次判定結果の判定(false, zenkaiNijiHanteiKekka),
                zenkaiNijiHanteiKekka,
                受給_二次判定有効期間の判定(false, zenkaiNijiHanteiNintei),
                zenkaiNijiHanteiNintei,
                受給_認定有効開始日Fromの判定(false, zenkaiYukoKikanStartFrom),
                zenkaiYukoKikanStartFrom,
                受給_認定有効開始日Toの判定(false, zenkaiYukoKikanStartTo),
                zenkaiYukoKikanStartTo,
                false,
                Code.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                FlexibleDate.EMPTY,
                false,
                Code.EMPTY,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                isTuChiSyoRi,
                limitCount
        );
    }

    private static boolean 受給_被保険者番号の判定(boolean isHihokenshaNo, RString hihokenshaNo) {
        if (!RString.isNullOrEmpty(hihokenshaNo)) {
            isHihokenshaNo = true;
        }
        return isHihokenshaNo;
    }

    private static boolean 受給_保険者の判定(boolean isShoKisaiHokenshaNo, RString shoKisaiHokenshaNo) {
        if (!RString.isNullOrEmpty(shoKisaiHokenshaNo)) {
            isShoKisaiHokenshaNo = true;
        }
        return isShoKisaiHokenshaNo;
    }

    private static boolean 受給_支所の判定(boolean isShishoCode, RString shishoCode) {
        if (!RString.isNullOrEmpty(shishoCode)) {
            isShishoCode = true;
        }
        return isShishoCode;
    }

    private static boolean 受給_被保険者氏名の判定(boolean isHihokenshaName, RString hihokenshaName) {
        if (!RString.isNullOrEmpty(hihokenshaName)) {
            isHihokenshaName = true;
        }
        return isHihokenshaName;
    }

    private static boolean 受給_前方一致の判定(boolean isJyoKenMae, RString jyoKen) {
        if (jyoKen.equals(new RString("key0"))) {
            isJyoKenMae = true;
        }
        return isJyoKenMae;
    }

    private static boolean 受給_後方一致の判定(boolean isJyoKenAto, RString jyoKen) {
        if (jyoKen.equals(new RString("key3"))) {
            isJyoKenAto = true;
        }
        return isJyoKenAto;
    }

    private static boolean 受給_部分一致の判定(boolean isJyoKenBuFun, RString jyoKen) {
        if (jyoKen.equals(new RString("key2"))) {
            isJyoKenBuFun = true;
        }
        return isJyoKenBuFun;
    }

    private static boolean 受給_認定申請日Fromの判定(boolean isNinteiShinseiYMDFrom, FlexibleDate ninteiShinseiYMDFrom) {
        if (ninteiShinseiYMDFrom != null
                && !ninteiShinseiYMDFrom.isEmpty()) {
            isNinteiShinseiYMDFrom = true;
        }
        return isNinteiShinseiYMDFrom;
    }

    private static boolean 受給_認定申請日Toの判定(boolean isNinteiShinseiYMDTo, FlexibleDate ninteiShinseiYMDTo) {
        if (ninteiShinseiYMDTo != null
                && !ninteiShinseiYMDTo.isEmpty()) {
            isNinteiShinseiYMDTo = false;
        }
        return isNinteiShinseiYMDTo;
    }

    private static boolean 受給_生年月日Fromの判定(boolean isSeinengappiYMDFrom, FlexibleDate seinengappiYMDFrom) {
        if (seinengappiYMDFrom != null && !seinengappiYMDFrom.isEmpty()) {
            isSeinengappiYMDFrom = true;
        }
        return isSeinengappiYMDFrom;
    }

    private static boolean 受給_生年月日Toの判定(boolean isSeinengappiYMDTo, FlexibleDate seinengappiYMDTo) {
        if (seinengappiYMDTo != null && !seinengappiYMDTo.isEmpty()) {
            isSeinengappiYMDTo = true;
        }
        return isSeinengappiYMDTo;
    }

    private static boolean 受給_申請区分_申請時の判定(boolean isNinteiShinseiKubunCode,
            Code ninteiShinseiKubunCode) {
        if (ninteiShinseiKubunCode != null
                && !ninteiShinseiKubunCode.value().isEmpty()) {
            isNinteiShinseiKubunCode = true;
        }
        return isNinteiShinseiKubunCode;
    }

    private static boolean 受給_被保険者区分の判定(boolean isHihokenshaKubunCode, RString hihokenshaKubunCode) {
        if (!RString.isNullOrEmpty(hihokenshaKubunCode)) {
            isHihokenshaKubunCode = true;
        }
        return isHihokenshaKubunCode;
    }

    private static boolean 受給_性別の判定(boolean isSeibetsu, Code seibetsu) {
        if (seibetsu != null
                && !seibetsu.value().isEmpty()) {
            isSeibetsu = true;
        }
        return isSeibetsu;
    }

    private static boolean 受給_申請区分_法令の判定(boolean isNinteiShinseiHoreiKubunCode, Code ninteiShinseiHoreiKubunCode) {
        if (!RString.isNullOrEmpty(ninteiShinseiHoreiKubunCode.value())) {
            isNinteiShinseiHoreiKubunCode = true;
        }
        return isNinteiShinseiHoreiKubunCode;
    }

    private static boolean 受給_処理状態区分の判定(boolean isShoriJotaiKubun, Code shoriJotaiKubun) {
        if (!RString.isNullOrEmpty(shoriJotaiKubun.value())) {
            isShoriJotaiKubun = true;
        }
        return isShoriJotaiKubun;
    }

    private static boolean 受給_郵便番号の判定(boolean isYubinNo, YubinNo yubinNo) {
        if (!RString.isNullOrEmpty(yubinNo.value())) {
            isYubinNo = true;
        }
        return isYubinNo;
    }

    private static boolean 受給_地区コードの判定(boolean isChikuCode, ChikuCode chikuCode) {
        if (!RString.isNullOrEmpty(chikuCode.value())) {
            isChikuCode = true;
        }
        return isChikuCode;
    }

    private static boolean 受給_認定調査委託先名称の判定(boolean isJigyoshaMeisho, RString jigyoshaMeisho) {
        if (!RString.isNullOrEmpty(jigyoshaMeisho)) {
            isJigyoshaMeisho = true;
        }
        return isJigyoshaMeisho;
    }

    private static boolean 受給_認定調査員氏名の判定(boolean isChosainShimei, RString chosainShimei) {
        if (!RString.isNullOrEmpty(chosainShimei)) {
            isChosainShimei = true;
        }
        return isChosainShimei;
    }

    private static boolean 受給_調査実施場所の判定(boolean isChosaJisshiBashoCode, Code chosaJisshiBashoCode) {
        if (!RString.isNullOrEmpty(chosaJisshiBashoCode.value())) {
            isChosaJisshiBashoCode = true;
        }
        return isChosaJisshiBashoCode;
    }

    private static boolean 受給_調査区分の判定(boolean isNinteiChosaKubunCode, Code ninteiChosaKubunCode) {
        if (!RString.isNullOrEmpty(ninteiChosaKubunCode.value())) {
            isNinteiChosaKubunCode = true;
        }
        return isNinteiChosaKubunCode;
    }

    private static boolean 受給_調査実施日Fromの判定(boolean isNinteichosaJisshiYMDFrom, FlexibleDate ninteichosaJisshiYMDFrom) {
        if (ninteichosaJisshiYMDFrom != null && !ninteichosaJisshiYMDFrom.isEmpty()) {
            isNinteichosaJisshiYMDFrom = true;
        }
        return isNinteichosaJisshiYMDFrom;
    }

    private static boolean 受給_調査実施日Toの判定(boolean isNinteichosaJisshiYMDTo, FlexibleDate ninteichosaJisshiYMDTo) {
        if (ninteichosaJisshiYMDTo != null && !ninteichosaJisshiYMDTo.isEmpty()) {
            isNinteichosaJisshiYMDTo = true;
        }
        return isNinteichosaJisshiYMDTo;
    }

    private static boolean 受給_寝たきり度の判定(boolean isNinchisho, Code ninchishoNichijoSeiCode) {
        if (!RString.isNullOrEmpty(ninchishoNichijoSeiCode.value())) {
            isNinchisho = true;
        }
        return isNinchisho;
    }

    private static boolean 受給_認知度の判定(boolean isShogai, Code shogaiNichijoJiritsudoCode) {
        if (!RString.isNullOrEmpty(shogaiNichijoJiritsudoCode.value())) {
            isShogai = true;
        }
        return isShogai;
    }

    private static boolean 受給_主治医医療機関名称の判定(boolean isIryoKikanMeisho, RString iryoKikanMeisho) {
        if (!RString.isNullOrEmpty(iryoKikanMeisho)) {
            isIryoKikanMeisho = true;
        }
        return isIryoKikanMeisho;
    }

    private static boolean 受給_主治医氏名の判定(boolean isShujiiName, RString shujiiName) {
        if (!RString.isNullOrEmpty(shujiiName)) {
            isShujiiName = true;
        }
        return isShujiiName;
    }

    private static boolean 受給_主治医区分の判定(boolean isIshiKubunCode, Code ishiKubunCode) {
        if (!RString.isNullOrEmpty(ishiKubunCode.value())) {
            isIshiKubunCode = true;
        }
        return isIshiKubunCode;
    }

    private static boolean 受給_意見受領日Fromの判定(boolean isIkenshoJuryoYMDFrom, FlexibleDate ikenshoJuryoYMDFrom) {
        if (ikenshoJuryoYMDFrom != null && !ikenshoJuryoYMDFrom.isEmpty()) {
            isIkenshoJuryoYMDFrom = true;
        }
        return isIkenshoJuryoYMDFrom;
    }

    private static boolean 受給_意見受領日Toの判定(boolean isIkenshoJuryoYMDTo, FlexibleDate ikenshoJuryoYMDTo) {
        if (ikenshoJuryoYMDTo != null && !ikenshoJuryoYMDTo.isEmpty()) {
            isIkenshoJuryoYMDTo = true;
        }
        return isIkenshoJuryoYMDTo;
    }

    private static boolean 受給_寝たきり度の判定(boolean isNeTaKiRi, RString neTaKiRi) {
        if (!RString.isNullOrEmpty(neTaKiRi)) {
            isNeTaKiRi = true;
        }
        return isNeTaKiRi;
    }

    private static boolean 受給_認知度の判定(boolean isNiChiDo, RString niChiDo) {
        if (!RString.isNullOrEmpty(niChiDo)) {
            isNiChiDo = true;
        }
        return isNiChiDo;
    }

    private static boolean 受給_一次判定日Fromの判定(boolean isIchijiHanteiYMDFrom, FlexibleDate ichijiHanteiYMDFrom) {
        if (ichijiHanteiYMDFrom != null && !ichijiHanteiYMDFrom.isEmpty()) {
            isIchijiHanteiYMDFrom = true;
        }
        return isIchijiHanteiYMDFrom;
    }

    private static boolean 受給_一次判定日Toの判定(boolean isIchijiHanteiYMDTo, FlexibleDate ichijiHanteiYMDTo) {
        if (ichijiHanteiYMDTo != null && !ichijiHanteiYMDTo.isEmpty()) {
            isIchijiHanteiYMDTo = true;
        }
        return isIchijiHanteiYMDTo;
    }

    private static boolean 受給_一次判定結果の判定(boolean isIchijiHanteiKekkaCode, Code ichijiHanteiKekkaCode) {
        if (!RString.isNullOrEmpty(ichijiHanteiKekkaCode.value())) {
            isIchijiHanteiKekkaCode = true;
        }
        return isIchijiHanteiKekkaCode;
    }

    private static boolean 受給_認定調査委託先の判定(boolean isZenkaiJigyoshaMeisho, RString zenkaiJigyoshaMeisho) {
        if (!RString.isNullOrEmpty(zenkaiJigyoshaMeisho)) {
            isZenkaiJigyoshaMeisho = true;
        }
        return isZenkaiJigyoshaMeisho;
    }

    private static boolean 受給_主治医医療機関の判定(boolean isZenkaiIryoKikanMeisho, RString zenkaiIryoKikanMeisho) {
        if (!RString.isNullOrEmpty(zenkaiIryoKikanMeisho)) {
            isZenkaiIryoKikanMeisho = true;
        }
        return isZenkaiIryoKikanMeisho;
    }

    private static boolean 受給_二次判定結果の判定(boolean isZenkaiNijiHanteiKekka, Code zenkaiNijiHanteiKekka) {
        if (!RString.isNullOrEmpty(zenkaiNijiHanteiKekka.value())) {
            isZenkaiNijiHanteiKekka = true;
        }
        return isZenkaiNijiHanteiKekka;
    }

    private static boolean 受給_二次判定有効期間の判定(boolean isZenkaiNijiHanteiNintei, int zenkaiNijiHanteiNintei) {
        if (zenkaiNijiHanteiNintei != 0) {
            isZenkaiNijiHanteiNintei = true;
        }
        return isZenkaiNijiHanteiNintei;
    }

    private static boolean 受給_認定有効開始日Fromの判定(boolean isZenkaiYukoKikanStartFrom, FlexibleDate zenkaiYukoKikanStartFrom) {
        if (zenkaiYukoKikanStartFrom != null && !zenkaiYukoKikanStartFrom.isEmpty()) {
            isZenkaiYukoKikanStartFrom = true;
        }
        return isZenkaiYukoKikanStartFrom;
    }

    private static boolean 受給_認定有効開始日Toの判定(boolean isZenkaiYukoKikanStartTo, FlexibleDate zenkaiYukoKikanStartTo) {
        if (zenkaiYukoKikanStartTo != null && !zenkaiYukoKikanStartTo.isEmpty()) {
            isZenkaiYukoKikanStartTo = true;
        }
        return isZenkaiYukoKikanStartTo;
    }

    /**
     * 被保険者番号フラグを返します。
     *
     * @return 被保険者番号フラグ
     */
    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

    /**
     * 保険者フラグを返します。
     *
     * @return 保険者フラグ
     */
    public boolean isIsShoKisaiHokenshaNo() {
        return isShoKisaiHokenshaNo;
    }

    /**
     * 支所フラグを返します。
     *
     * @return 支所フラグ
     */
    public boolean isIsShishoCode() {
        return isShishoCode;
    }

    /**
     * 被保険者氏名フラグを返します。
     *
     * @return 被保険者氏名フラグ
     */
    public boolean isIsHihokenshaName() {
        return isHihokenshaName;
    }

    /**
     * 前方一致フラグを返します。
     *
     * @return 前方一致フラグ
     */
    public boolean isIsJyoKenMae() {
        return isJyoKenMae;
    }

    /**
     * 後方一致フラグを返します。
     *
     * @return 後方一致フラグ
     */
    public boolean isIsJyoKenAto() {
        return isJyoKenAto;
    }

    /**
     * 部分一致フラグを返します。
     *
     * @return 部分一致フラグ
     */
    public boolean isIsJyoKenBuFun() {
        return isJyoKenBuFun;
    }

    /**
     * みなし２号申請を返します。
     *
     * @return みなし２号申請
     */
    public boolean isIsMinashiNigoEtcTaishoFlag() {
        return isMinashiNigoEtcTaishoFlag;
    }

    /**
     * 認定申請日Fromフラグを返します。
     *
     * @return 認定申請日Fromフラグ
     */
    public boolean isIsNinteiShinseiYMDFrom() {
        return isNinteiShinseiYMDFrom;
    }

    /**
     * 認定申請日Toフラグを返します。
     *
     * @return 認定申請日Toフラグ
     */
    public boolean isIsNinteiShinseiYMDTo() {
        return isNinteiShinseiYMDTo;
    }

    /**
     * 生年月日Fromフラグを返します。
     *
     * @return 生年月日Fromフラグ
     */
    public boolean isIsSeinengappiYMDFrom() {
        return isSeinengappiYMDFrom;
    }

    /**
     * 生年月日Toフラグを返します。
     *
     * @return 生年月日Toフラグ
     */
    public boolean isIsSeinengappiYMDTo() {
        return isSeinengappiYMDTo;
    }

    /**
     * 申請区分(申請時)フラグを返します。
     *
     * @return 申請区分(申請時)フラグ
     */
    public boolean isIsNinteiShinseiKubunCode() {
        return isNinteiShinseiKubunCode;
    }

    /**
     * 性別フラグを返します。
     *
     * @return 性別フラグ
     */
    public boolean isIsSeibetsu() {
        return isSeibetsu;
    }

    /**
     * 被保険者区分フラグを返します。
     *
     * @return 被保険者区分フラグ
     */
    public boolean isIsHihokenshaKubunCode() {
        return isHihokenshaKubunCode;
    }

    /**
     * 申請区分(法令)フラグを返します。
     *
     * @return 申請区分(法令)フラグ
     */
    public boolean isIsNinteiShinseiHoreiKubunCode() {
        return isNinteiShinseiHoreiKubunCode;
    }

    /**
     * 処理状態区分フラグを返します。
     *
     * @return 処理状態区分フラグ
     */
    public boolean isIsShoriJotaiKubun() {
        return isShoriJotaiKubun;
    }

    /**
     * 郵便番号フラグを返します。
     *
     * @return 郵便番号フラグ
     */
    public boolean isIsYubinNo() {
        return isYubinNo;
    }

    /**
     * 地区コードフラグを返します。
     *
     * @return 地区コードフラグ
     */
    public boolean isIsChikuCode() {
        return isChikuCode;
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    public boolean isIsShisetsuNyushoFlag() {
        return isShisetsuNyushoFlag;
    }

    /**
     * 認定調査委託先名称フラグを返します。
     *
     * @return 認定調査委託先名称フラグ
     */
    public boolean isIsJigyoshaMeisho() {
        return isJigyoshaMeisho;
    }

    /**
     * 認定調査員氏名フラグを返します。
     *
     * @return 認定調査員氏名フラグ
     */
    public boolean isIsChosainShimei() {
        return isChosainShimei;
    }

    /**
     * 調査実施場所フラグを返します。
     *
     * @return 調査実施場所フラグ
     */
    public boolean isIsChosaJisshiBashoCode() {
        return isChosaJisshiBashoCode;
    }

    /**
     * 調査区分フラグを返します。
     *
     * @return 調査区分フラグ
     */
    public boolean isIsNinteiChosaKubunCode() {
        return isNinteiChosaKubunCode;
    }

    /**
     * 調査実施日Fromフラグを返します。
     *
     * @return 調査実施日Fromフラグ
     */
    public boolean isIsNinteichosaJisshiYMDFrom() {
        return isNinteichosaJisshiYMDFrom;
    }

    /**
     * 調査実施日Toフラグを返します。
     *
     * @return 調査実施日Toフラグ
     */
    public boolean isIsNinteichosaJisshiYMDTo() {
        return isNinteichosaJisshiYMDTo;
    }

    /**
     * 寝たきり度フラグを返します。
     *
     * @return 寝たきり度
     */
    public boolean isIsNinchisho() {
        return isNinchisho;
    }

    /**
     * 認知度フラグを返します。
     *
     * @return 認知度フラグ
     */
    public boolean isIsShogai() {
        return isShogai;
    }

    /**
     * 主治医医療機関名称フラグを返します。
     *
     * @return 主治医医療機関名称フラグ
     */
    public boolean isIsIryoKikanMeisho() {
        return isIryoKikanMeisho;
    }

    /**
     * 主治医氏名フラグを返します。
     *
     * @return 主治医氏名フラグ
     */
    public boolean isIsShujiiName() {
        return isShujiiName;
    }

    /**
     * 主治医区分フラグを返します。
     *
     * @return 主治医区分フラグ
     */
    public boolean isIsIshiKubunCode() {
        return isIshiKubunCode;
    }

    /**
     * 意見書受領日Fromフラグを返します。
     *
     * @return 意見書受領日Fromフラグ
     */
    public boolean isIsIkenshoJuryoYMDFrom() {
        return isIkenshoJuryoYMDFrom;
    }

    /**
     * 意見書受領日Toフラグを返します。
     *
     * @return 意見書受領日Toフラグ
     */
    public boolean isIsIkenshoJuryoYMDTo() {
        return isIkenshoJuryoYMDTo;
    }

    /**
     * 寝たきり度フラグを返します。
     *
     * @return 寝たきり度フラグ
     */
    public boolean isIsNeTaKiRi() {
        return isNeTaKiRi;
    }

    /**
     * 認知度フラグを返します。
     *
     * @return 認知度フラグ
     */
    public boolean isIsNiChiDo() {
        return isNiChiDo;
    }

    /**
     * 一次判定日Fromフラグを返します。
     *
     * @return 一次判定日Fromフラグ
     */
    public boolean isIsIchijiHanteiYMDFrom() {
        return isIchijiHanteiYMDFrom;
    }

    /**
     * 一次判定日Toフラグを返します。
     *
     * @return 一次判定日Toフラグ
     */
    public boolean isIsIchijiHanteiYMDTo() {
        return isIchijiHanteiYMDTo;
    }

    /**
     * 一次判定結果フラグを返します。
     *
     * @return 一次判定結果フラグ
     */
    public boolean isIsIchijiHanteiKekkaCode() {
        return isIchijiHanteiKekkaCode;
    }

    /**
     * 1.5次判定日Fromフラグを返します。
     *
     * @return 1.5次判定日Fromフラグ
     */
    public boolean isIsIchiGojiHanteiYMDFrom() {
        return isIchiGojiHanteiYMDFrom;
    }

    /**
     * 1.5次判定日Toフラグを返します。
     *
     * @return 1.5次判定日Toフラグ
     */
    public boolean isIsIchiGojiHanteiYMDTo() {
        return isIchiGojiHanteiYMDTo;
    }

    /**
     * 1.5次判定結果フラグを返します。
     *
     * @return 1.5次判定結果フラグ
     */
    public boolean isIsIchiGojiHanteiKekkaCode() {
        return isIchiGojiHanteiKekkaCode;
    }

    /**
     * 二次判定結果フラグを返します。
     *
     * @return 二次判定結果フラグ
     */
    public boolean isIsNijiHanteiKekkaInputHoho() {
        return isNijiHanteiKekkaInputHoho;
    }

    /**
     * 認定有効期間フラグを返します。
     *
     * @return 認定有効期間フラグ
     */
    public boolean isIsNijiHanteiNinteiYukoKikan() {
        return isNijiHanteiNinteiYukoKikan;
    }

    /**
     * 認定有効開始日Toフラグを返します。
     *
     * @return 認定有効開始日Toフラグ
     */
    public boolean isIsNijiHanteiNinteiYMDTo() {
        return isNijiHanteiNinteiYMDTo;
    }

    /**
     * 認定有効終了日Formフラグを返します。
     *
     * @return 認定有効終了日Formフラグ
     */
    public boolean isIsNijiHanteiNinteiYMDFrom() {
        return isNijiHanteiNinteiYMDFrom;
    }

    /**
     * 認定有効終了日Toフラグを返します。
     *
     * @return 認定有効終了日Toフラグ
     */
    public boolean isIsNijiHanteiNinteiYMD() {
        return isNijiHanteiNinteiYMDTo;
    }

    /**
     * 二次判定結果Formフラグを返します。
     *
     * @return 二次判定結果Formフラグ
     */
    public boolean isIsNijiHanteiKekkaInputYMDFrom() {
        return isNijiHanteiKekkaInputYMDFrom;
    }

    /**
     * 二次判定結果Toフラグを返します。
     *
     * @return 二次判定結果Toフラグ
     */
    public boolean isIsNijiHanteiKekkaInputYMDTo() {
        return isNijiHanteiKekkaInputYMDTo;
    }

    /**
     * 開催日Fromフラグを返します。
     *
     * @return 開催日Fromフラグ
     */
    public boolean isIsShinsakaiKaisaiYMDFrom() {
        return isShinsakaiKaisaiYMDFrom;
    }

    /**
     * 開催日Toフラグを返します。
     *
     * @return 開催日Toフラグ
     */
    public boolean isIsShinsakaiKaisaiYMDTo() {
        return isShinsakaiKaisaiYMDTo;
    }

    /**
     * 開催番号Fromフラグを返します。
     *
     * @return 開催番号Fromフラグ
     */
    public boolean isIsShinsakaiKaisaiNoFrom() {
        return isShinsakaiKaisaiNoFrom;
    }

    /**
     * 開催番号Toフラグを返します。
     *
     * @return 開催番号Toフラグ
     */
    public boolean isIsShinsakaiKaisaiNoTo() {
        return isShinsakaiKaisaiNoTo;
    }

    /**
     * 前回認定調査委託先フラグを返します。
     *
     * @return 前回認定調査委託先フラグ
     */
    public boolean isIsZenkaiJigyoshaMeisho() {
        return isZenkaiJigyoshaMeisho;
    }

    /**
     * 前回主治医医療機関フラグを返します。
     *
     * @return 前回主治医医療機関フラグ
     */
    public boolean isIsZenkaiIryoKikanMeisho() {
        return isZenkaiIryoKikanMeisho;
    }

    /**
     * 前回二次判定結果フラグを返します。
     *
     * @return 前回二次判定結果フラグ
     */
    public boolean isIsZenkaiNijiHanteiKekka() {
        return isZenkaiNijiHanteiKekka;
    }

    /**
     * 前回二次判定有効期間フラグを返します。
     *
     * @return 前回二次判定有効期間フラグ
     */
    public boolean isIsZenkaiNijiHanteiNintei() {
        return isZenkaiNijiHanteiNintei;
    }

    /**
     * 前回認定有効開始日Fromフラグを返します。
     *
     * @return 前回認定有効開始日Fromフラグ
     */
    public boolean isIsZenkaiYukoKikanStartFrom() {
        return isZenkaiYukoKikanStartFrom;
    }

    /**
     * 前回認定有効開始日Toフラグを返します。
     *
     * @return 前回認定有効開始日Toフラグ
     */
    public boolean isIsZenkaiYukoKikanStartTo() {
        return isZenkaiYukoKikanStartTo;
    }

    /**
     * 原因疾患フラグを返します。
     *
     * @return 原因疾患フラグ
     */
    public boolean isIsGeninShikkanCode() {
        return isGeninShikkanCode;
    }

    /**
     * 経過日数Formフラグを返します。
     *
     * @return 経過日数Formフラグ
     */
    public boolean isIsNinteiShinseiYMDSystemFrom() {
        return isNinteiShinseiYMDSystemFrom;
    }

    /**
     * 経過日数Toフラグを返します。
     *
     * @return 経過日数Toフラグ
     */
    public boolean isIsNinteiShinseiYMDSystemTo() {
        return isNinteiShinseiYMDSystemTo;
    }

    /**
     * 更新対象フラグを返します。
     *
     * @return 更新対象フラグ
     */
    public boolean isIsKoShiTaiJyo() {
        return isKoShiTaiJyo;
    }

    /**
     * 要介護認定一次判定完了年月日フラグを返します。
     *
     * @return 要介護認定一次判定完了年月日フラグ
     */
    public boolean isIsIchijiHanteiKanryoYMD() {
        return isIchijiHanteiKanryoYMD;
    }

    /**
     * 認定申請情報登録完了年月日フラグを返します。
     *
     * @return 認定申請情報登録完了年月日フラグ
     */
    public boolean isIsNinteiShinseiJohoYMD() {
        return isNinteiShinseiJohoYMD;
    }

    /**
     * マスキング完了年月日フラグを返します。
     *
     * @return マスキング完了年月日フラグ
     */
    public boolean isIsMaskingKanryoYMD() {
        return isMaskingKanryoYMD;
    }

    /**
     * 調査依頼完了年月日フラグを返します。
     *
     * @return 調査依頼完了年月日フラグ
     */
    public boolean isIsNinteichosaIraiKanryoYMD() {
        return isNinteichosaIraiKanryoYMD;
    }

    /**
     * 認定審査会割り当て完了年月日フラグを返します。
     *
     * @return 認定審査会割り当て完了年月日フラグ
     */
    public boolean isIsNinteiShinsakaiWariateYMD() {
        return isNinteiShinsakaiWariateYMD;
    }

    /**
     * 主治医意見書作成依頼完了年月日フラグを返します。
     *
     * @return 主治医意見書作成依頼完了年月日フラグ
     */
    public boolean isIsIkenshoSakuseiIraiKanryoYMD() {
        return isIkenshoSakuseiIraiKanryoYMD;
    }

    /**
     * 認定審査会完了年月日フラグを返します。
     *
     * @return 認定審査会完了年月日フラグ
     */
    public boolean isIsNinteiShinsakaiKanryoYMD() {
        return isNinteiShinsakaiKanryoYMD;
    }

    /**
     * 認定調査完了年月日フラグを返します。
     *
     * @return 認定調査完了年月日フラグ
     */
    public boolean isIsNinteichosaKanryoYMD() {
        return isNinteichosaKanryoYMD;
    }

    /**
     * 通知処理フラグを返します。
     *
     * @return 通知処理フラグ
     */
    public boolean isIsIkenshoTorokuKanryoYMD() {
        return isIkenshoTorokuKanryoYMD;
    }

    /**
     * 主治医意見書登録完了年月日フラグを返します。
     *
     * @return 主治医意見書登録完了年月日フラグ
     */
    public boolean isIsCenterSoshinYMD() {
        return isCenterSoshinYMD;
    }

    /**
     * 主センター送信年月日フラグを返します。
     *
     * @return センター送信年月日フラグ
     */
    public boolean isIsTuChiSyoRi() {
        return isTuChiSyoRi;
    }

    /**
     * 認定有効終了日フラグを返します。
     *
     * @return 認定有効終了日フラグ
     */
    public boolean isIsNijiHanteiShuryoYMDFrom() {
        return isNijiHanteiShuryoYMDFrom;
    }

    /**
     * 認定有効終了日フラグを返します。
     *
     * @return 認定有効終了日フラグ
     */
    public boolean isIsNijiHanteiShuryoYMDTo() {
        return isNijiHanteiShuryoYMDTo;
    }
}
