/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
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
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyoukSgJg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.Image;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SearchSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        gaikyoDiv.getBtnBack().setDisabled(false);
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
        gaikyoDiv.getShisetsuRiyoPanel().getImgRiyoShisetsuMeisho().setDisplayNone(true);
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
        int count = 0;
        if (ServiceKubunCode.予防給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
            count = 15;
        }
        if (ServiceKubunCode.介護給付サービス.getコード().equals(getkubun(0, serviceJokyos))) {
            count = 20;
        }

        for (int i = 0; i < count; i++) {
            dgServiceJokyo_Row dgJigyoshaItiran = new dgServiceJokyo_Row();
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())
                    && (未実施).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return GaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
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
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
        }
        return RString.EMPTY;
    }

    private RString getTan2(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            if ((実施済).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V99A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V02A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V06A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V09A.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (KoroshoInterfaceShikibetsuCode.V09B.getCode().equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
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
            setサービス区分(gaikyoBusiness);

            if (TokkijikoTextImageKubun.テキスト.getコード().equals(gaikyoDiv.getHdnTextImageKubun())) {
                setText認定調査実施場所(gaikyoBusiness);
                setText概況調査特記(gaikyoBusiness);
                setTextサービス(gaikyoBusiness);
                setText利用施設情報(gaikyoBusiness);
                setText概況特記(gaikyoBusiness);
            } else {
                Image image = ChosaKekkaInfoGaikyoFinder.createInstance().get5115Image(gaikyoParameter);
                setImage認定調査実施場所(image);
                setImage概況調査特記(image);
                setImageサービス(gaikyoBusiness, image);
                setImage利用施設情報(image);
                setImage概況特記(image);
            }
        }
    }

    private void set認定調査実施日(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness) {
        if (gaikyoBusiness.get認定調査実施年月日() != null) {
            gaikyoDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(gaikyoBusiness.get認定調査実施年月日().toString()));
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

    private void setImage認定調査実施場所(Image image) {
        RString 実施場所ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_認定調査実施場所);
        gaikyoDiv.getJisshiBashoMeishoPanel().getImgChosaJisshiBashoMeisho().setSrc(実施場所ImagePath);
    }

    private void setImage概況調査特記(Image image) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況調査特記ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_概況調査特記);
            gaikyoDiv.getGaikyoChosaTokkiPanel().getImgGaikyoChosaTokki().setSrc(概況調査特記ImagePath);
        }
    }

    private void setImageサービス(ChosaKekkaInfoGaikyoBusiness gaikyoBusiness, Image image) {
        if (!出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            if (gaikyoBusiness.get記入項目連番() == 1) {
                RString 市町村特別給付ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_市町村特別給付);
                gaikyoDiv.getTokubetsuKyufuPanel().getImgTokubetsuKyufu().setSrc(市町村特別給付ImagePath);
            } else {
                RString 在宅サービスImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_在宅サービス);
                gaikyoDiv.getZaitakuServicePanel().getImgZaitakuService().setSrc(在宅サービスImagePath);
            }
        }
    }

    private void setImage利用施設情報(Image image) {
        RString 施設名称ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_利用施設名);
        RString 施設住所ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_利用施設住所);
        RString 電話番号ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_電話番号);
        gaikyoDiv.getShisetsuRiyoPanel().getImgRiyoShisetsuMeisho().setSrc(施設名称ImagePath);
        gaikyoDiv.getShisetsuRiyoPanel().getImgRiyoShisetsuJusho().setSrc(施設住所ImagePath);
        gaikyoDiv.getShisetsuRiyoPanel().getImgTelNo().setSrc(電話番号ImagePath);
    }

    private void setImage概況特記(Image image) {
        if (出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            RString 概況特記ImagePath = 共有ファイルを引き出す(image, IMAGEFILENAME_概況特記);
            gaikyoDiv.getGaikyoTokkiPanel().getImgGaikyoTokki().setSrc(概況特記ImagePath);
        }
    }

    private RString 共有ファイルを引き出す(Image イメージ情報, RString ファイル名) {
        RString imagePath = RString.EMPTY;
        if (イメージ情報 != null) {
            imagePath = getFilePath(イメージ情報.getイメージ共有ファイルID(), ファイル名);
        }
        return imagePath;
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        RString FileaPath = SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath)).toRString();
        return getImageSrc(Path.combinePath(FileaPath, replaceShareFileName(sharedFileName, false)));
    }

    private RString replaceShareFileName(RString sharedFileName, boolean isExistマスク) {
        if (isExistマスク) {
            return sharedFileName.replace(".png", "_BAK.png");
        }
        return sharedFileName;
    }

    private RString getImageSrc(RString path) {
        return Path.combinePath(new RString(File.separator + "db"), new RString("dbe"), path.substring(path.indexOf("image")));
    }

}
