/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import static jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei.単一市町村;
import static jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei.広域保険者;
import static jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei.広域審査会;
import static jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei.広域市町村;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteiatenainfo.KaigoNinteiAtenaInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.hokensha.HdnShoriTypeStatus;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigoninteiatenainfo.KaigoNinteiAtenaInfoParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv.AtenaType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo.KaigoNinteiAtenaInfoDiv.ShoriType;
import jp.co.ndensan.reams.db.dbz.service.core.kaigoninteiatenainfo.KaigoNinteiAtenaInfoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.memo.MemoShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定宛名情報の取得するクラスです。
 *
 * @reamsid_L DBZ-1300-050 lizhuoxuan
 */
public class KaigoNinteiAtenaInfoHandler {

    private final KaigoNinteiAtenaInfoDiv div;
    private static final RString JUTONAI_IMAGE_PATH = new RString("/uz/uza/image/UZ_Person_Jutonai.png");
    private static final RString JUTOGAI_IMAGE_PATH = new RString("/uz/uza/image/UZ_Person_Jutogai.png");

    /**
     * コンストラクタです。
     *
     * @param kaigoNinteiAtenaInfoDiv 介護認定宛名情報の共有子のエンティティ
     */
    public KaigoNinteiAtenaInfoHandler(KaigoNinteiAtenaInfoDiv kaigoNinteiAtenaInfoDiv) {
        this.div = kaigoNinteiAtenaInfoDiv;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        //隠し項目の介護導入形態の値により、宛名モードを設定です。
        if (!RString.isNullOrEmpty(div.getHdnKaigoDonyuKeitai())) {
            switch (HokenshaKosei.toValue(div.getHdnKaigoDonyuKeitai())) {
                case 単一市町村:
                case 広域市町村:
                case 広域保険者:
                    div.setMode_AtenaType(AtenaType.AtenaMode);
                    break;
                case 広域審査会:
                    div.setMode_AtenaType(AtenaType.AtenaNonMode);
                    break;
                default:
                    break;
            }
        }

        //隠し項目の処理タイプの値により、処理タイプモードを設定です。
        if (!RString.isNullOrEmpty(div.getHdnShoriType())) {
            switch (HdnShoriTypeStatus.toValue(div.getHdnShoriType())) {
//                case NomalAddMode:
//                    break;
//                case NomalUpdateMode:
//                    div.setMode_ShoriType(ShoriType.NormalUpdateMode);
//                    break;
//                case SeihoAddMode:
//                    div.setMode_ShoriType(ShoriType.SeihoAddMode);
//                    break;
                case SeihoUpdateMode:
                    div.setMode_ShoriType(ShoriType.SeihoUpdateMode);
                    break;
                case ShokaiMode:
                    div.setMode_ShoriType(ShoriType.ShokaiMode);
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 親画面より受け取った識別コードをキーに宛名情報を検索し、画面の申請者情報へセットします。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param shikibetsuCode ShikibetsuCode
     */
    public void setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo shinseishoKanriNo, ShikibetsuCode shikibetsuCode) {
        // 宛名識別対象PSM
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.未定義
                ), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        if (!RString.isNullOrEmpty(shikibetsuCode.value()) && !RString.isNullOrEmpty(shinseishoKanriNo.value())) {
            KaigoNinteiAtenaInfoParameter infoParameter = KaigoNinteiAtenaInfoParameter.createSelectByKeyParam(shikibetsuCode.value(), shinseishoKanriNo.value(),
                    new RString(uaFt200Psm.toString()));
            List<KaigoNinteiAtenaInfoBusiness> ninteiList = KaigoNinteiAtenaInfoManager.createInstance()
                    .getKaigoNinteiAtenaInfo(infoParameter).records();
            if (ninteiList != null && !ninteiList.isEmpty()) {
                set介護認定宛名情報(ninteiList.get(0));
            }
        }
    }

    /**
     *
     * @param business
     */
    public void set介護認定宛名情報(KaigoNinteiAtenaInfoBusiness business) {
        div.getTxtShimei().setValue(business.get氏名());
        div.getTxtBirthYMD().setValue(new RDate(business.get生年月日().toString()));
        div.getTxtNenrei().setValue(business.get年齢());
        div.getTxtSeibetsu().setValue(business.get性別());
        div.getTxtJuminShubetsu().setValue(business.get住民種別コード());
        div.getTxtShikiBetsuCode().setValue(business.get識別コード());
        div.getTxtKojinNo().setValue(new RString(business.get個人番号().toString()));
        div.getTxtYubinNo().setValue(business.get郵便番号());
        div.getTxtJusho().setDomain(business.get住所());
        div.getTxtTelNo().setDomain(business.get連絡先());
        div.getTxtGyoseiku().setValue(business.get行政区名());
        div.getTxtSetaiCode().setDomain(business.get世帯コード());
        setImgJuminShubetsu();
    }

    /**
     *
     * 個人メモ画面のパラメータを設定します。
     *
     */
    public void setShikiParam() {
        div.setHdnSubGyomuCode(SubGyomuCode.DBZ介護共通.getGyomuCode().value());
        div.setKojinMemoShikibetsuKubun(MemoShikibetsuTaisho.識別コード.get識別対象());
        div.setMemoShikibetsuCode(RString.isNullOrEmpty(div.getTxtShikiBetsuCode().getValue())
                ? RString.EMPTY : div.getTxtShikiBetsuCode().getValue());
    }

    /**
     *
     * 個人メモ画面のパラメータを取得します。
     *
     */
    public void getShikiParam() {
        div.getHdnSubGyomuCode();
        div.getMemoShikibetsuCode();
        div.getSetaiMemoShikibetsuKubun();
    }

    /**
     *
     * 世帯メモ画面のパラメータを設定します。
     *
     */
    public void setSetaiParam() {
        div.setHdnSubGyomuCode(SubGyomuCode.DBZ介護共通.getGyomuCode().value());
        div.setSetaiMemoShikibetsuKubun(MemoShikibetsuTaisho.世帯コード.get識別対象());
        div.setMemoShikibetsuCode(RString.isNullOrEmpty(div.getTxtShikiBetsuCode().getValue())
                ? RString.EMPTY : div.getTxtShikiBetsuCode().getValue());
    }

    /**
     *
     * 世帯メモ画面のパラメータを取得します。
     *
     */
    public void geSetaiParam() {
        div.getHdnSubGyomuCode();
        div.getMemoShikibetsuCode();
        div.getKojinMemoShikibetsuKubun();
    }

    /**
     * 住民種別のアイコンを変更処理です。
     */
    public void setImgJuminShubetsu() {
        if (div.getMode_AtenaType() != null && RString.isNullOrEmpty(new RString(div.getMode_AtenaType().toString()))
                && div.getMode_AtenaType().equals(AtenaType.AtenaMode)) {
            switch (JuminShubetsu.toValue(div.getTxtJuminShubetsu().getValue())) {
                //住登内
                case 日本人:
                case 外国人:
                case 法人:
                case 共有者:
                    div.getImgJuminShubetsu().setSrc(JUTONAI_IMAGE_PATH);
                    break;
                //住登外
                case 住登外個人_日本人:
                case 住登外個人_外国人:
                    div.getImgJuminShubetsu().setSrc(JUTOGAI_IMAGE_PATH);
                    break;
                default:
                    break;
            }
        }

    }

}
