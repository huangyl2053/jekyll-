/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.business.core.util.DBEImageUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyoukSgJg;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.IGaikyoChosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyoukinyukomoku.GaikyoChosahyouKinyuKomoku99A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyouNiteichosahyouSisetuRiy99A;
import jp.co.ndensan.reams.db.dbe.definition.core.kanri.ImageFileName;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果情報照会_概況調査の取得するクラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyoHandler {

    private final ChosaKekkaInfoGaikyoDiv gaikyoDiv;
    private static final RString 出力する = new RString("1");
    private static final RString 実施済 = new RString("2");
    private static final RString Enum区分_サービス = new RString("1");
    private static final RString Enum区分_サービスフラグ = new RString("2");
    private static final RString 予防給付サービス = new RString("介護予防");
    private static final RString 介護給付サービス = new RString("介護");

    /**
     * コンストラクタです。
     *
     * @param gaikyoDiv 認定調査結果情報照会_概況調査
     */
    public ChosaKekkaInfoGaikyoHandler(ChosaKekkaInfoGaikyoDiv gaikyoDiv) {
        this.gaikyoDiv = gaikyoDiv;
    }

    /**
     * onLoad処理です。
     *
     * @param chosaKekkaInfoGaikyoList 認定調査結果情報照会_概況調査クラス
     * @param serviceJokyos 認定調査結果情報照会_概況調査クラス
     * @param shisetsuRiyos 認定調査結果情報照会_概況調査クラス
     * @param gaikyoParameter 概況調査パラメータ
     */
    public void onLoad(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList, List<RembanServiceJokyoBusiness> serviceJokyos,
            List<NinteichosahyoShisetsuRiyo> shisetsuRiyos, ChosaKekkaInfoGaikyoParameter gaikyoParameter) {
        gaikyoDiv.getBtnReturn().setDisabled(false);
        setDisabledコントロール();
        if (TokkijikoTextImageKubun.テキスト.getコード().equals(gaikyoDiv.getHdnTextImageKubun())) {
            setDisplayNoneイメージコントロール();
        } else {
            setDisplayNoneテキストコントロール();
        }
        set認定調査委託先認定調査員(chosaKekkaInfoGaikyoList);
        set利用施設種類(shisetsuRiyos);
        setサービス状況(serviceJokyos);
        set住宅改修(serviceJokyos);
        set概況調査(chosaKekkaInfoGaikyoList, gaikyoParameter);
    }

    private void setDisabledコントロール() {
        gaikyoDiv.getTxtNinteichosaJisshiYMD().setDisabled(true);
        gaikyoDiv.getTxtChosaJisshiBashoMeisho().setDisabled(true);
        gaikyoDiv.getGaikyoChosaTokkiPanel().setDisabled(true);
        gaikyoDiv.getServiceJokyoPanel().setDisabled(true);
        gaikyoDiv.getRadServiceKubun().setDisabled(true);
        gaikyoDiv.getRdoJutakuKaishu().setDisabled(true);
        gaikyoDiv.getTokubetsuKyufuPanel().setDisabled(true);
        gaikyoDiv.getZaitakuServicePanel().setDisabled(true);
        gaikyoDiv.getShisetsuRiyoPanel().setDisabled(true);
    }

    private void setDisplayNoneテキストコントロール() {
        gaikyoDiv.getTxtChosaJisshiBashoMeisho().setDisplayNone(true);
        gaikyoDiv.getGaikyoChosaTokkiPanel().getTxtGaikyoChosaTokki().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getTxtRiyoShisetsuMeisho().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getTxtTelNo().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getTxtRiyoShisetsuJusho().setDisplayNone(true);
        gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblJutakuKaishu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtJutakuKaishu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblGaikyoTokkiTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblZaitakuService().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiZaitakuService().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblShuso().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtShuso().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblKazokuJokyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKazokuJokyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblKyojuKankyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKyojuKankyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLblKikaiKiki().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKikaiKiki().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine1().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine2().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine3().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine4().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine5().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getLine6().setDisplayNone(true);
    }

    private void setDisplayNoneイメージコントロール() {
        gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setDisplayNone(true);
        gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getImgTelNo().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getImgRiyoShisetsuJusho().setDisplayNone(true);
        gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setDisplayNone(true);
        gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().setDisplayNone(true);
        gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().setDisplayNone(true);
        gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getImgTokubetsuKyufuSmall().setDisplayNone(true);
        gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getImgZaitakuServiceSmall().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setDisplayNone(true);
    }

    /**
     * 利用施設名称を取得します。
     */
    private void set利用施設種類(List<NinteichosahyoShisetsuRiyo> shisetsuRiyosList) {
        for (NinteichosahyoShisetsuRiyo shisetsuRiyo : shisetsuRiyosList) {
            if (shisetsuRiyo.is施設利用フラグ()) {
                if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getTxtRiyoShisetsuShurui().setValue(
                            GaikyoChosahyouNiteichosahyouSisetuRiy99A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
                }
                if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getTxtRiyoShisetsuShurui().setValue(
                            GaikyoChosahyouNiteichosahyouSisetuRiy02A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
                }
                if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getTxtRiyoShisetsuShurui().setValue(
                            GaikyoChosahyouNiteichosahyouSisetuRiy06A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
                }
                if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getTxtRiyoShisetsuShurui().setValue(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
                }
                if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getTxtRiyoShisetsuShurui().setValue(
                            GaikyoChosahyouNiteichosahyouSisetuRiy09B.toValue(new RString(shisetsuRiyo.get連番())).get名称());
                }
            }
        }
    }

    /**
     * 概況調査_サービス状況を取得します。
     */
    private List<dgServiceJokyo_Row> setサービス状況(List<RembanServiceJokyoBusiness> serviceJokyos) {
        List<dgServiceJokyo_Row> dgServiceJokyo_Row = new ArrayList<>();
        boolean isOdd = false;
        dgServiceJokyo_Row dgJigyoshaItiran = new dgServiceJokyo_Row();
        for (RembanServiceJokyoBusiness serviceJokyo : serviceJokyos) {
            if (Enum区分_サービス.equals(serviceJokyo.getEnum区分())) {
                if (!isOdd) {
                    dgJigyoshaItiran = new dgServiceJokyo_Row();
                    setDataGridJigyoshaItiran(dgJigyoshaItiran, serviceJokyo, isOdd);
                    if (RString.isNullOrEmpty(dgJigyoshaItiran.getServiceName1())) {
                        continue;
                    }
                    isOdd = true;
                    continue;
                }
                setDataGridJigyoshaItiran(dgJigyoshaItiran, serviceJokyo, isOdd);
                if (RString.isNullOrEmpty(dgJigyoshaItiran.getServiceName2())) {
                    continue;
                }
                isOdd = false;
                dgServiceJokyo_Row.add(dgJigyoshaItiran);
            }
        }
        if (isOdd && !RString.isNullOrEmpty(dgJigyoshaItiran.getServiceName1())) {
            dgServiceJokyo_Row.add(dgJigyoshaItiran);
        }
        gaikyoDiv.getServiceJokyoPanel().getDgServiceJokyo().setDataSource(dgServiceJokyo_Row);
        return dgServiceJokyo_Row;
    }

    private void setDataGridJigyoshaItiran(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            boolean isOdd) {
        IGaikyoChosahyoServiceJokyo 概況調査サービス状況;
        if ((実施済).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_AfterV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyo.get厚労省IF識別コード().value())) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_BeforeV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyo.get厚労省IF識別コード().value())) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_BeforeV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyo.get厚労省IF識別コード().value())) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_AfterV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyo.get厚労省IF識別コード().value())) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_AfterV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyo.get厚労省IF識別コード().value())) {
            try {
                概況調査サービス状況 = CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyo.get連番()));
            } catch (Exception e) {
                概況調査サービス状況 = null;
            }
            setDataGridJigyoshaItiran_AfterV06A(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        }
    }

    private void setDataGridJigyoshaItiran_BeforeV06A(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況,
            boolean isOdd) {
        if (概況調査サービス状況 != null) {
            setDataGridJigyoshaItiranPlacement(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
        } else {
            setDataGridJigyoshaItiran_Empty(dgJigyoshaItiran, isOdd);
        }
    }

    private void setDataGridJigyoshaItiran_AfterV06A(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況,
            boolean isOdd) {
        if (概況調査サービス状況 != null) {
            if (概況調査サービス状況.get給付区分().equals(get給付区分(serviceJokyo.getサービス区分コード()))) {
                setDataGridJigyoshaItiranPlacement(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
            } else if (介護給付サービス.equals(get給付区分(serviceJokyo.getサービス区分コード()))) {
                setDataGridJigyoshaItiranPlacement(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況, isOdd);
            } else {
                setDataGridJigyoshaItiran_Empty(dgJigyoshaItiran, isOdd);
            }
        } else {
            setDataGridJigyoshaItiran_Empty(dgJigyoshaItiran, isOdd);
        }
    }

    private void setDataGridJigyoshaItiran_Empty(dgServiceJokyo_Row dgJigyoshaItiran, boolean isOdd) {
        if (isOdd) {
            dgJigyoshaItiran.setServiceName2(RString.EMPTY);
            dgJigyoshaItiran.setTatsu2(RString.EMPTY);
            dgJigyoshaItiran.setServiceJokyo2(RString.EMPTY);
            dgJigyoshaItiran.setKai2(RString.EMPTY);
        } else {
            dgJigyoshaItiran.setServiceName1(RString.EMPTY);
            dgJigyoshaItiran.setTatsu1(RString.EMPTY);
            dgJigyoshaItiran.setServiceJokyo1(RString.EMPTY);
            dgJigyoshaItiran.setKai1(RString.EMPTY);
        }
    }

    private void setDataGridJigyoshaItiranPlacement(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況,
            boolean isOdd) {
        if (isOdd) {
            setDataGridJigyoshaItiranDetail_Right(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況);
        } else {
            setDataGridJigyoshaItiranDetail_Left(dgJigyoshaItiran, serviceJokyo, 概況調査サービス状況);
        }
    }

    private void setDataGridJigyoshaItiranDetail_Left(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況) {
        dgJigyoshaItiran.setServiceName1(概況調査サービス状況.get名称());
        dgJigyoshaItiran.setKai1(概況調査サービス状況.get単位1());
        dgJigyoshaItiran.setServiceJokyo1(new RString(serviceJokyo.getサービスの状況フラグ()));
        dgJigyoshaItiran.setTatsu1(概況調査サービス状況.get単位2());
    }

    private void setDataGridJigyoshaItiranDetail_Right(dgServiceJokyo_Row dgJigyoshaItiran,
            RembanServiceJokyoBusiness serviceJokyo,
            IGaikyoChosahyoServiceJokyo 概況調査サービス状況) {
        dgJigyoshaItiran.setServiceName2(概況調査サービス状況.get名称());
        dgJigyoshaItiran.setKai2(概況調査サービス状況.get単位1());
        dgJigyoshaItiran.setServiceJokyo2(new RString(serviceJokyo.getサービスの状況フラグ()));
        dgJigyoshaItiran.setTatsu2(概況調査サービス状況.get単位2());
    }

    private RString get給付区分(RString サービス区分) {
        if (ServiceKubunCode.予防給付サービス.getコード().equals(サービス区分)) {
            return 予防給付サービス;
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(サービス区分)) {
            return 介護給付サービス;
        } else {
            return RString.EMPTY;
        }
    }

    private void set概況調査(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList,
            ChosaKekkaInfoGaikyoParameter gaikyoParameter) {
        for (ChosaKekkaInfoGaikyoBusiness gaikyoBusiness : chosaKekkaInfoGaikyoList) {
            set認定調査実施日(gaikyoBusiness);
            set認定調査実施場所コード(gaikyoBusiness);
            setサービス区分(gaikyoBusiness);

            if (TokkijikoTextImageKubun.テキスト.getコード().equals(gaikyoDiv.getHdnTextImageKubun())) {
                setText認定調査実施場所(gaikyoBusiness);
                setText概況調査特記(gaikyoBusiness);
                setTextサービス(gaikyoBusiness);
                setText利用施設情報(gaikyoBusiness);
                setText概況特記(gaikyoBusiness);
            } else {
                Image image = ChosaKekkaInfoGaikyoFinder.createInstance().get5115Image(gaikyoParameter);
                RString 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, RString.class);
                RString 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, RString.class);
                RString 共有ファイル名 = 証記載保険者番号.concat(被保険者番号);
                RString 出力イメージフォルダパス = DBEImageUtil.copySharedFiles(image.getイメージ共有ファイルID(), 共有ファイル名);

                setImage認定調査実施場所(出力イメージフォルダパス);
                setImage概況調査特記(出力イメージフォルダパス);
                setImageサービス(出力イメージフォルダパス);
                setImage利用施設情報(出力イメージフォルダパス);
                setImage概況特記(出力イメージフォルダパス);
            }
        }
    }

    private void set認定調査実施日(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        if (gaikyoBusiness.get認定調査実施年月日() != null) {
            gaikyoDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(gaikyoBusiness.get認定調査実施年月日().toString()));
        }
    }

    private void set認定調査実施場所コード(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        if (gaikyoBusiness.get認定調査実施場所コード() != null) {
            ChosaJisshiBashoCode 実施場所 = ChosaJisshiBashoCode.toValue(gaikyoBusiness.get認定調査実施場所コード().value());
            gaikyoDiv.getTxtChosaJisshiBashoCode().setValue(実施場所.get名称());
        }
    }

    private void setサービス区分(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        if (ServiceKubunCode.予防給付サービス.getコード().equals(
                ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
            gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key0"));
        } else if (ServiceKubunCode.介護給付サービス.getコード().equals(
                ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
            gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key1"));
        } else if (ServiceKubunCode.なし.getコード().equals(
                ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
            gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key2"));
        }
    }

    /**
     * 住宅改修を取得します。
     */
    private void set住宅改修(List<RembanServiceJokyoBusiness> serviceJokyos) {
        for (RembanServiceJokyoBusiness jokyoBusiness : serviceJokyos) {
            if (Enum区分_サービスフラグ.equals(jokyoBusiness.getEnum区分())) {
                if (jokyoBusiness.get連番() == 1) {
                    if (jokyoBusiness.getサービスの状況フラグ() == 1) {
                        gaikyoDiv.getRdoJutakuKaishu().setSelectedKey(new RString("key0"));
                    } else {
                        gaikyoDiv.getRdoJutakuKaishu().setSelectedKey(new RString("key1"));
                    }
                }
            }
        }
    }

    private void setText認定調査実施場所(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        gaikyoDiv.getTxtChosaJisshiBashoMeisho().setValue(gaikyoBusiness.get認定調査実施場所名称());
    }

    private void setText概況調査特記(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        gaikyoDiv.getGaikyoChosaTokkiPanel().getTxtGaikyoChosaTokki().setValue(gaikyoBusiness.get特記());
    }

    private void setTextサービス(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
            if (GaikyoChosahyouKinyuKomoku99A.市町村特別給付.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setValue(gaikyoBusiness.getサービスの状況記入());
            } else if (GaikyoChosahyouKinyuKomoku99A.介護保険給付外の在宅サービス.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(gaikyoBusiness.getサービスの状況記入());
            }
        }
        if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
            if (GaikyoChosahyouKinyuKomoku02A.市町村特別給付.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setValue(gaikyoBusiness.getサービスの状況記入());
            } else if (GaikyoChosahyouKinyuKomoku02A.介護保険給付外の在宅サービス.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(gaikyoBusiness.getサービスの状況記入());
            }
        }
        if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
            if (GaikyoChosahyouKinyuKomoku06A.市町村特別給付.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setValue(gaikyoBusiness.getサービスの状況記入());
            } else if (GaikyoChosahyouKinyuKomoku06A.介護保険給付外の在宅サービス.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(gaikyoBusiness.getサービスの状況記入());
            }
        }
        if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
            if (GaikyoChosahyouKinyuKomoku09A.市町村特別給付.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setValue(gaikyoBusiness.getサービスの状況記入());
            } else if (GaikyoChosahyouKinyuKomoku09A.介護保険給付外の在宅サービス.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(gaikyoBusiness.getサービスの状況記入());
            }
        }
        if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
            if (GaikyoChosahyouKinyuKomoku09B.市町村特別給付.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getTokubetsuKyufuPanel().getTxtTokubetsuKyufu().setValue(gaikyoBusiness.getサービスの状況記入());
            } else if (GaikyoChosahyouKinyuKomoku09B.介護保険給付外の在宅サービス.get連番().equals(new RString(gaikyoBusiness.get記入項目連番()))) {
                gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(gaikyoBusiness.getサービスの状況記入());
            }
        }
    }

    private void setText利用施設情報(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        gaikyoDiv.getTxtRiyoShisetsuMeisho().setValue(gaikyoBusiness.get利用施設名());
        gaikyoDiv.getTxtRiyoShisetsuJusho().setValue(gaikyoBusiness.get利用施設住所());
        gaikyoDiv.getTxtTelNo().setValue(gaikyoBusiness.get利用施設電話番号());
    }

    private void setText概況特記(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        gaikyoDiv.getGaikyoTokkiPanel().getTxtJutakuKaishu().setValue(gaikyoBusiness.get住宅改修_改修箇所());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiTokubetsuKyufu().setValue(gaikyoBusiness.get市町村特別給付サービス種類名());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiZaitakuService().setValue(gaikyoBusiness.get介護保険給付以外の在宅サービス種類名());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtShuso().setValue(gaikyoBusiness.get概況特記事項_主訴());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKazokuJokyo().setValue(gaikyoBusiness.get概況特記事項_家族状況());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKyojuKankyo().setValue(gaikyoBusiness.get概況特記事項_居住環境());
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKikaiKiki().setValue(gaikyoBusiness.get概況特記事項_機器_器械());
    }

    private void setImage認定調査実施場所(RString 出力イメージフォルダパス) {
        RString 実施場所ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.調査実施場所.getImageFileName());
        if (RString.isNullOrEmpty(実施場所ImagePath)) {
            gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setDisplayNone(true);
            gaikyoDiv.getJisshiBashoMeishoPanel().getLblNoImageJisshiBasho().setDisplayNone(false);
        } else {
            gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setSrc(DBEImageUtil.sanitizePath(実施場所ImagePath));
        }
    }

    private void setImage概況調査特記(RString 出力イメージフォルダパス) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況調査特記ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.概況調査特記.getImageFileName());
            if (RString.isNullOrEmpty(概況調査特記ImagePath)) {
                gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setDisplayNone(true);
                gaikyoDiv.getGaikyoChosaTokkiPanel().getLblNoImageGaikyoChosaTokki().setDisplayNone(false);
            } else {
                gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setSrc(DBEImageUtil.sanitizePath(概況調査特記ImagePath));
            }
        }
    }

    private void setImageサービス(RString 出力イメージフォルダパス) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 市町村特別給付ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.市町村特別給付.getImageFileName());
            boolean isタイルタイプ = false;
            if (new FlexibleDate(gaikyoDiv.getHdnNinteiShinseibi()).isBeforeOrEquals(
                    new FlexibleDate(DbBusinessConfig.get(ConfigNameDBE.認定調査票特記事項_様式切替日, RDate.getNowDate(), SubGyomuCode.DBE認定支援)))) {
                isタイルタイプ = true;
            }
            if (RString.isNullOrEmpty(市町村特別給付ImagePath)) {
                gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setDisplayNone(true);
                gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().setDisplayNone(true);
                gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getLblImgTokubetsuKyufuSmall().setDisplayNone(true);
                gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getImgTokubetsuKyufuSmall().setDisplayNone(true);
                gaikyoDiv.getTokubetsuKyufuPanel().getLblNoImageTokubetsuKyufu().setDisplayNone(false);
            } else {
                if (isタイルタイプ) {
                    gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getLblImgTokubetsuKyufuSmall().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getImgTokubetsuKyufuSmall().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getLblNoImageTokubetsuKyufu().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setSrc(DBEImageUtil.sanitizePath(市町村特別給付ImagePath));
                } else {
                    gaikyoDiv.getTokubetsuKyufuPanel().getLblNoImageTokubetsuKyufu().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().setDisplayNone(false);
                    gaikyoDiv.getTokubetsuKyufuPanel().getTokubetsuKyufuSmallPanel().getLblImgTokubetsuKyufuSmall().setDisplayNone(true);
                    gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufuSmall().setSrc(DBEImageUtil.sanitizePath(市町村特別給付ImagePath));
                }
            }
            RString 在宅サービスImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.介護保険給付外のサービス.getImageFileName());
            if (RString.isNullOrEmpty(在宅サービスImagePath)) {
                gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().setDisplayNone(true);
                gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getImgZaitakuServiceSmall().setDisplayNone(true);
                gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getLblImgZaitakuServiceSmall().setDisplayNone(true);
                gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setDisplayNone(true);
                gaikyoDiv.getZaitakuServicePanel().getLblNoImageZaitakuService().setDisplayNone(false);
            } else {
                if (isタイルタイプ) {
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getImgZaitakuServiceSmall().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getLblImgZaitakuServiceSmall().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getLblNoImageZaitakuService().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setSrc(DBEImageUtil.sanitizePath(在宅サービスImagePath));
                } else {
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().setDisplayNone(false);
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getImgZaitakuServiceSmall().setDisplayNone(false);
                    gaikyoDiv.getZaitakuServicePanel().getZaitakuServiceSmallPanel().getLblImgZaitakuServiceSmall().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getLblNoImageZaitakuService().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setDisplayNone(true);
                    gaikyoDiv.getZaitakuServicePanel().getImgZaitakuServiceSmall().setSrc(DBEImageUtil.sanitizePath(在宅サービスImagePath));
                }
            }
        } else {
            gaikyoDiv.getTokubetsuKyufuPanel().setDisplayNone(true);
            gaikyoDiv.getZaitakuServicePanel().setDisplayNone(true);
        }
    }

    private void setImage利用施設情報(RString 出力イメージフォルダパス) {
        RString 施設名称ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設名.getImageFileName());
        if (RString.isNullOrEmpty(施設名称ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getLblNoImageRiyoShisetsuMeisho().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho().setSrc(DBEImageUtil.sanitizePath(施設名称ImagePath));
        }

        RString 施設住所ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設住所.getImageFileName());
        if (RString.isNullOrEmpty(施設住所ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getImgRiyoShisetsuJusho().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getLblNoImageRiyoShisetsuJusho().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getImgRiyoShisetsuJusho().setSrc(DBEImageUtil.sanitizePath(施設住所ImagePath));
        }

        RString 電話番号ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.施設電話番号.getImageFileName());
        if (RString.isNullOrEmpty(電話番号ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getImgTelNo().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getLblNoImageTelNo().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getImgTelNo().setSrc(DBEImageUtil.sanitizePath(電話番号ImagePath));
        }
    }

    private void setImage概況特記(RString 出力イメージフォルダパス) {
        if (出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況特記ImagePath = DBEImageUtil.getMaskOrOriginalImageFilePath(出力イメージフォルダパス, ImageFileName.概況特記.getImageFileName());
            if (RString.isNullOrEmpty(概況特記ImagePath)) {
                gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setDisplayNone(true);
                gaikyoDiv.getGaikyoTokkiPanel().getLblNoImageGaikyoTokki().setDisplayNone(false);
            } else {
                gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setSrc(DBEImageUtil.sanitizePath(概況特記ImagePath));
            }
        }
    }

    private void set認定調査委託先認定調査員(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList) {
        gaikyoDiv.getTxtChosaItakusakiCode().setValue(chosaKekkaInfoGaikyoList.get(0).get調査委託先コード());
        gaikyoDiv.getTxtChosaItakusakiName().setValue(chosaKekkaInfoGaikyoList.get(0).get事業者名称());
        gaikyoDiv.getTxtNinteiChosainCode().setValue(chosaKekkaInfoGaikyoList.get(0).get調査員コード());
        gaikyoDiv.getTxtNinteiChosainName().setValue(chosaKekkaInfoGaikyoList.get(0).get調査員氏名());
    }
}
