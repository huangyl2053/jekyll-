/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.CKGaikyoChosahyouServiceJyoukSgJg;
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
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
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
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.util._Base64Converter;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Path;
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
    private static final RString 未実施 = new RString("1");
    private static final RString 出力する = new RString("1");
    private static final RString 実施済 = new RString("2");
    private static final RString 予防給付サービス = new RString("介護予防");
    private static final RString 介護給付サービス = new RString("介護");
    private static final RString IMAGEFILENAME_認定調査実施場所 = new RString("C0001.png");
    private static final RString IMAGEFILENAME_市町村特別給付 = new RString("C0002.png");
    private static final RString IMAGEFILENAME_在宅サービス = new RString("C0003.png");
    private static final RString IMAGEFILENAME_利用施設名 = new RString("C0004.png");
    private static final RString IMAGEFILENAME_利用施設住所 = new RString("C0005.png");
    private static final RString IMAGEFILENAME_電話番号 = new RString("C0006.png");
    private static final RString IMAGEFILENAME_概況調査特記 = new RString("C0007.png");
    private static final RString IMAGEFILENAME_概況特記 = new RString("G0001.png");

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
        gaikyoDiv.getGaikyoTokkiPanel().getTxtJutakuKaishu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtGaikyoTokkiZaitakuService().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtShuso().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKazokuJokyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKyojuKankyo().setDisplayNone(true);
        gaikyoDiv.getGaikyoTokkiPanel().getTxtKikaiKiki().setDisplayNone(true);
    }

    private void setDisplayNoneイメージコントロール() {
        gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setDisplayNone(true);
        gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getImgTelNo().setDisplayNone(true);
        gaikyoDiv.getShisetsuRiyoPanel().getImgRiyoShisetsuJusho().setDisplayNone(true);
        gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setDisplayNone(true);
        gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setDisplayNone(true);
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
        List<dgServiceJokyo_Row> grdSinsaSeiList = new ArrayList<>();
        RString 厚労省IF識別コード = RString.EMPTY;
        int count = 0;
        if (serviceJokyos != null && !serviceJokyos.isEmpty()) {
            厚労省IF識別コード = serviceJokyos.get(0).get厚労省IF識別コード().value();
        }
        if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード)) {
            count = GaikyoChosahyouServiceJyouk99A.values().length;
        } else if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード)) {
            count = GaikyoChosahyouServiceJyouk02A.values().length;
        } else if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード)) {
            if (ServiceKubunCode.予防給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk06A.get給付サービスRecordSize(予防給付サービス);
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk06A.get給付サービスRecordSize(介護給付サービス);
            }
        } else if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード)) {
            if (ServiceKubunCode.予防給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk09A.get給付サービスRecordSize(予防給付サービス);
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk09A.get給付サービスRecordSize(介護給付サービス);
            }
        } else if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
            if (ServiceKubunCode.予防給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk09B.get給付サービスRecordSize(予防給付サービス);
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
                count = CKGaikyoChosahyouServiceJyouk09B.get給付サービスRecordSize(介護給付サービス);
            }
        }
        for (int i = 0; i < count; i++) {
            dgServiceJokyo_Row dgJigyoshaItiran = new dgServiceJokyo_Row();
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(厚労省IF識別コード)) {
                dgJigyoshaItiran.setServiceName1(getName(i, serviceJokyos));
                dgJigyoshaItiran.setTatsu1(getTan2(i, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo1(getFlag(i, serviceJokyos));
                dgJigyoshaItiran.setKai1(getTan1(i, serviceJokyos));
                dgJigyoshaItiran.setServiceName2(getName(i + count, serviceJokyos));
                dgJigyoshaItiran.setTatsu2(getTan2(i + count, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo2(getFlag(i + count, serviceJokyos));
                dgJigyoshaItiran.setKai2(getTan1(i + count, serviceJokyos));
                grdSinsaSeiList.add(dgJigyoshaItiran);
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(厚労省IF識別コード)) {
                dgJigyoshaItiran.setServiceName1(getName(i, serviceJokyos));
                dgJigyoshaItiran.setTatsu1(getTan2(i, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo1(getFlag(i, serviceJokyos));
                dgJigyoshaItiran.setKai1(getTan1(i, serviceJokyos));
                dgJigyoshaItiran.setServiceName2(getName(i + count, serviceJokyos));
                dgJigyoshaItiran.setTatsu2(getTan2(i + count, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo2(getFlag(i + count, serviceJokyos));
                dgJigyoshaItiran.setKai2(getTan1(i + count, serviceJokyos));
                grdSinsaSeiList.add(dgJigyoshaItiran);
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(厚労省IF識別コード)) {
                dgJigyoshaItiran.setServiceName1(getName(i, serviceJokyos));
                dgJigyoshaItiran.setTatsu1(getTan2(i, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo1(getFlag(i, serviceJokyos));
                dgJigyoshaItiran.setKai1(getTan1(i, serviceJokyos));
                dgJigyoshaItiran.setServiceName2(getName(i + count, serviceJokyos));
                dgJigyoshaItiran.setTatsu2(getTan2(i + count, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo2(getFlag(i + count, serviceJokyos));
                dgJigyoshaItiran.setKai2(getTan1(i + count, serviceJokyos));
                grdSinsaSeiList.add(dgJigyoshaItiran);
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(厚労省IF識別コード)) {
                dgJigyoshaItiran.setServiceName1(getName(i, serviceJokyos));
                dgJigyoshaItiran.setTatsu1(getTan2(i, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo1(getFlag(i, serviceJokyos));
                dgJigyoshaItiran.setKai1(getTan1(i, serviceJokyos));
                dgJigyoshaItiran.setServiceName2(getName(i + count, serviceJokyos));
                dgJigyoshaItiran.setTatsu2(getTan2(i + count, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo2(getFlag(i + count, serviceJokyos));
                dgJigyoshaItiran.setKai2(getTan1(i + count, serviceJokyos));
                grdSinsaSeiList.add(dgJigyoshaItiran);
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(厚労省IF識別コード)) {
                dgJigyoshaItiran.setServiceName1(getName(i, serviceJokyos));
                dgJigyoshaItiran.setTatsu1(getTan2(i, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo1(getFlag(i, serviceJokyos));
                dgJigyoshaItiran.setKai1(getTan1(i, serviceJokyos));
                dgJigyoshaItiran.setServiceName2(getName(i + count, serviceJokyos));
                dgJigyoshaItiran.setTatsu2(getTan2(i + count, serviceJokyos));
                dgJigyoshaItiran.setServiceJokyo2(getFlag(i + count, serviceJokyos));
                dgJigyoshaItiran.setKai2(getTan1(i + count, serviceJokyos));
                grdSinsaSeiList.add(dgJigyoshaItiran);
            }
        }
        gaikyoDiv.getServiceJokyoPanel().getDgServiceJokyo().setDataSource(grdSinsaSeiList);
        return grdSinsaSeiList;
    }

    private RString getName(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            if ((実施済).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return CKGaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())
                    && (未実施).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString getkubun(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            return serviceJokyos.get(連番).getEnum区分();
        }
        return RString.EMPTY;
    }

    private RString getTan1(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            if ((実施済).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return CKGaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
        }
        return RString.EMPTY;
    }

    private RString getTan2(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            if ((実施済).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return CKGaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return CKGaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
        }
        return RString.EMPTY;
    }

    private RString getFlag(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            return new RString(serviceJokyos.get(連番).getサービスの状況フラグ());
        }
        return RString.EMPTY;
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
                RString 出力イメージフォルダパス = copySharedFiles(image, 共有ファイル名);

                setImage認定調査実施場所(出力イメージフォルダパス);
                setImage概況調査特記(出力イメージフォルダパス);
                setImageサービス(gaikyoBusiness, 出力イメージフォルダパス);
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
            if (jokyoBusiness.get連番() == 1) {
                if (jokyoBusiness.getサービスの状況フラグ() == 1) {
                    gaikyoDiv.getRdoJutakuKaishu().setSelectedKey(new RString("key0"));
                } else {
                    gaikyoDiv.getRdoJutakuKaishu().setSelectedKey(new RString("key1"));
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
        RString 実施場所ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_認定調査実施場所);
        if (RString.isNullOrEmpty(実施場所ImagePath)) {
            gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setDisplayNone(true);
            gaikyoDiv.getJisshiBashoMeishoPanel().getLblNoImageJisshiBasho().setDisplayNone(false);
        } else {
            gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setSrc(sanitizePath(実施場所ImagePath));
        }
    }

    private void setImage概況調査特記(RString 出力イメージフォルダパス) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況調査特記ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_概況調査特記);
            if (RString.isNullOrEmpty(概況調査特記ImagePath)) {
                gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setDisplayNone(true);
                gaikyoDiv.getGaikyoChosaTokkiPanel().getLblNoImageGaikyoChosaTokki().setDisplayNone(false);
            } else {
                gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setSrc(sanitizePath(概況調査特記ImagePath));
            }
        }
    }

    private void setImageサービス(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness, RString 出力イメージフォルダパス) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
//            if (gaikyoBusiness.get記入項目連番() == 1) {
            RString 市町村特別給付ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_市町村特別給付);
            if (RString.isNullOrEmpty(市町村特別給付ImagePath)) {
                gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setDisplayNone(true);
                gaikyoDiv.getTokubetsuKyufuPanel().getLblNoImageTokubetsuKyufu().setDisplayNone(false);
            } else {
                gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setSrc(sanitizePath(市町村特別給付ImagePath));
            }
//            } else {
            RString 在宅サービスImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_在宅サービス);
            if (RString.isNullOrEmpty(在宅サービスImagePath)) {
                gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setDisplayNone(true);
                gaikyoDiv.getZaitakuServicePanel().getLblNoImageZaitakuService().setDisplayNone(false);
            } else {
                gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setSrc(sanitizePath(在宅サービスImagePath));
            }
//            }
        }
    }

    private void setImage利用施設情報(RString 出力イメージフォルダパス) {
        RString 施設名称ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_利用施設名);
        if (RString.isNullOrEmpty(施設名称ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getLblNoImageRiyoShisetsuMeisho().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuMeishoPanel().getImgRiyoShisetsuMeisho().setSrc(sanitizePath(施設名称ImagePath));
        }

        RString 施設住所ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_利用施設住所);
        if (RString.isNullOrEmpty(施設住所ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getImgRiyoShisetsuJusho().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getLblNoImageRiyoShisetsuJusho().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getShisetsuJushoPanel().getImgRiyoShisetsuJusho().setSrc(sanitizePath(施設住所ImagePath));
        }

        RString 電話番号ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_電話番号);
        if (RString.isNullOrEmpty(電話番号ImagePath)) {
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getImgTelNo().setDisplayNone(true);
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getLblNoImageTelNo().setDisplayNone(false);
        } else {
            gaikyoDiv.getShisetsuRiyoPanel().getTelNoPanel().getImgTelNo().setSrc(sanitizePath(電話番号ImagePath));
        }
    }

    private void setImage概況特記(RString 出力イメージフォルダパス) {
        if (出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況特記ImagePath = getFilePath(出力イメージフォルダパス, IMAGEFILENAME_概況特記);
            if (RString.isNullOrEmpty(概況特記ImagePath)) {
                gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setDisplayNone(true);
                gaikyoDiv.getGaikyoTokkiPanel().getLblNoImageGaikyoTokki().setDisplayNone(false);
            } else {
                gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setSrc(sanitizePath(概況特記ImagePath));
            }
        }
    }

    private RString getFilePath(RString 出力イメージフォルダパス, RString ファイル名) {
        if (Directory.exists(Path.combinePath(出力イメージフォルダパス, ファイル名))) {
            return Path.combinePath(出力イメージフォルダパス, ファイル名);
        }
        return RString.EMPTY;
    }

    private RString copySharedFiles(Image イメージ情報, RString 共有ファイル名) {
        RString 出力イメージフォルダパス = Directory.createTmpDirectory();
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(共有ファイル名),
                        イメージ情報.getイメージ共有ファイルID());
        return new RString(SharedFile.copyToLocal(descriptor, new FilesystemPath(出力イメージフォルダパス)).getCanonicalPath());
    }

    private RString sanitizePath(RString imagePath) {
        RString DATAURI_BMP = new RString("data:image/png;base64,");
        return !imagePath.isEmpty() ? DATAURI_BMP.concat(base64encode(imagePath)) : RString.EMPTY;
    }

    private RString base64encode(RString イメージパス) {
        RString imgBase64 = RString.EMPTY;
        try {
            imgBase64 = _Base64Converter.encodeBase64RString(Files.readAllBytes(Paths.get(イメージパス.toString())));
        } catch (IOException ex) {
        }
        return imgBase64;
    }
}
