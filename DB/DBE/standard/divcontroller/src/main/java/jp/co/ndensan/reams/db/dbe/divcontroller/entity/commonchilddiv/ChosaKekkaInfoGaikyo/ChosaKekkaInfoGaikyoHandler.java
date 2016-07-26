/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;

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
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk02A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk06A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk09B;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyouk99A;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouservicejyouk.GaikyoChosahyouServiceJyoukSgJg;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_概況調査の取得するクラスです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyoHandler {

    private final ChosaKekkaInfoGaikyoDiv gaikyoDiv;
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString NINE = new RString("9");
    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");

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
     * @param path イメージ共有ファイルID
     */
    public void onLoad(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList, List<RembanServiceJokyoBusiness> serviceJokyos,
            List<NinteichosahyoShisetsuRiyo> shisetsuRiyos, RString path) {
        gaikyoDiv.getTxtNinteichosaJisshiYMD().setDisabled(true);
        gaikyoDiv.getTxtChosaJisshiBashoMeisho().setDisabled(true);
        gaikyoDiv.getTokkiPanel().setDisabled(true);
        gaikyoDiv.getServiceJokyoPanel().setDisabled(true);
        gaikyoDiv.getRadServiceKubun().setDisabled(true);
        gaikyoDiv.getRdoJutakuKaishu().setDisabled(true);
        gaikyoDiv.getKubetsuKyufuPanel().setDisabled(true);
        gaikyoDiv.getZaitakuServicePanel().setDisabled(true);
        gaikyoDiv.getRiyoShisetsuPanel().setDisabled(true);
        gaikyoDiv.getTxtRiyoShisetsuShimei().setDisabled(true);
        gaikyoDiv.getTxtRiyoShisetsuJusho().setDisabled(true);
        gaikyoDiv.getTxtTelNo().setDisabled(true);
        if (ONE.equals(gaikyoDiv.getGaikyoTokkiTextImageKubun())) {
            gaikyoDiv.getGaikyoTokkiTextPanel().setDisabled(true);
            gaikyoDiv.getGaikyoTokkiTextPanel().setVisible(true);
            gaikyoDiv.getGaikyoTokkiImagePanel().setVisible(false);
        }
        if (TWO.equals(gaikyoDiv.getGaikyoTokkiTextImageKubun())) {
            gaikyoDiv.getGaikyoTokkiImagePanel().setDisabled(true);
            gaikyoDiv.getGaikyoTokkiImagePanel().setVisible(true);
            gaikyoDiv.getGaikyoTokkiTextPanel().setDisabled(true);
            gaikyoDiv.getGaikyoTokkiTextPanel().setVisible(false);
            gaikyoDiv.getGaikyoTokkiImagePanel().getGaikyoChosaImage().setSrc(path);
        }
        gaikyoDiv.getBtnBack().setDisabled(false);
        setDataSourcre1(shisetsuRiyos);
        setDataSourcre2(serviceJokyos);
        setDataSourcre3(chosaKekkaInfoGaikyoList);
        setDataSourcre4(serviceJokyos);
    }

    /**
     * 利用施設一覧を取得します。
     */
    private List<dgRiyoShisetsu_Row> setDataSourcre1(List<NinteichosahyoShisetsuRiyo> shisetsuRiyosList) {
        List<dgRiyoShisetsu_Row> grdSinsaSeiList = new ArrayList<>();
        for (NinteichosahyoShisetsuRiyo shisetsuRiyo : shisetsuRiyosList) {
            dgRiyoShisetsu_Row dgJigyoshaItiran = new dgRiyoShisetsu_Row();
            dgJigyoshaItiran.setShisetsuRiyoFlag(shisetsuRiyo.is施設利用フラグ());
            if (A_99.equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setShisetsuRiyoFlagName(IkenshoKomokuMapping99A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
            }
            if (A_02.equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setShisetsuRiyoFlagName(IkenshoKomokuMapping02A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
            }
            if (A_06.equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setShisetsuRiyoFlagName(IkenshoKomokuMapping06A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
            }
            if (A_09.equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setShisetsuRiyoFlagName(IkenshoKomokuMapping09A.toValue(new RString(shisetsuRiyo.get連番())).get名称());
            }
            if (B_09.equals(shisetsuRiyo.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setShisetsuRiyoFlagName(IkenshoKomokuMapping09B.toValue(new RString(shisetsuRiyo.get連番())).get名称());
            }
            grdSinsaSeiList.add(dgJigyoshaItiran);
        }
        gaikyoDiv.getRiyoShisetsuPanel().getDgRiyoShisetsu().setDataSource(grdSinsaSeiList);
        return grdSinsaSeiList;
    }

    /**
     * 概況調査_サービス状況を取得します。
     */
    private List<dgServiceJokyo_Row> setDataSourcre2(List<RembanServiceJokyoBusiness> serviceJokyos) {
        List<dgServiceJokyo_Row> grdSinsaSeiList = new ArrayList<>();
        int count = 0;
        if (getkubun(0, serviceJokyos).equals(ONE)) {
            count = 15;
        }
        if (getkubun(0, serviceJokyos).equals(TWO)) {
            count = 20;
        }

        for (int i = 0; i < count; i++) {
            dgServiceJokyo_Row dgJigyoshaItiran = new dgServiceJokyo_Row();
            if (A_02.equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (A_06.equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (A_09.equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (A_99.equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if (B_09.equals(serviceJokyos.get(i).get厚労省IF識別コード().value())) {
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
            if ((TWO).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (A_02.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (A_06.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (A_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (A_99.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get名称();
            }
            if (B_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())
                    && (ONE).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
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
            if ((TWO).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (A_02.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (A_06.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (A_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (A_99.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
            if (B_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09B.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位1();
            }
        }
        return RString.EMPTY;
    }

    private RString getTan2(int 連番, List<RembanServiceJokyoBusiness> serviceJokyos) {
        if (連番 < serviceJokyos.size()) {
            if ((TWO).equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                return GaikyoChosahyouServiceJyoukSgJg.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (A_02.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk02A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (A_06.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk06A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (A_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk09A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (A_99.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
                return GaikyoChosahyouServiceJyouk99A.toValue(new RString(serviceJokyos.get(連番).get連番())).get単位2();
            }
            if (B_09.equals(serviceJokyos.get(連番).get厚労省IF識別コード().value())) {
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

    private void setDataSourcre3(List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList) {
        for (ChosaKekkaInfoGaikyoBusiness gaikyoBusiness : chosaKekkaInfoGaikyoList) {
            if (gaikyoBusiness.get認定調査実施年月日() != null) {
                gaikyoDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(gaikyoBusiness.get認定調査実施年月日().toString()));
            }
            gaikyoDiv.getTxtChosaJisshiBashoMeisho().setValue(gaikyoBusiness.get認定調査実施場所名称());
            gaikyoDiv.getTokkiPanel().getTxtTokki().setValue(gaikyoBusiness.get特記());
            if (ONE.equals(ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
                gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key0"));
            }
            if (TWO.equals(ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
                gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key1"));
            }
            if (NINE.equals(ServiceKubunCode.toValue(gaikyoBusiness.get認定調査_サービス区分コード().value()).getコード())) {
                gaikyoDiv.getRadServiceKubun().setSelectedKey(new RString("key2"));
            }
            if (gaikyoBusiness.get記入項目連番() == 1) {
                if (A_02.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getKubetsuKyufuPanel().getTxtkubetsuKyufu().setValue(GaikyoChosahyouKinyuKomoku02A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_99.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getKubetsuKyufuPanel().getTxtkubetsuKyufu().setValue(GaikyoChosahyouKinyuKomoku99A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_06.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getKubetsuKyufuPanel().getTxtkubetsuKyufu().setValue(GaikyoChosahyouKinyuKomoku06A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_09.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getKubetsuKyufuPanel().getTxtkubetsuKyufu().setValue(GaikyoChosahyouKinyuKomoku09A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (B_09.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getKubetsuKyufuPanel().getTxtkubetsuKyufu().setValue(GaikyoChosahyouKinyuKomoku09B.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
            } else {
                if (A_02.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(GaikyoChosahyouKinyuKomoku02A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_99.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(GaikyoChosahyouKinyuKomoku99A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_06.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(GaikyoChosahyouKinyuKomoku06A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (A_09.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(GaikyoChosahyouKinyuKomoku09A.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
                if (B_09.equals(gaikyoBusiness.get厚労省IF識別コード().value())) {
                    gaikyoDiv.getZaitakuServicePanel().getTxtZaitakuService().setValue(GaikyoChosahyouKinyuKomoku09B.
                            toValue(new RString(gaikyoBusiness.get記入項目連番())).get名称());
                }
            }
            gaikyoDiv.getTxtRiyoShisetsuShimei().setValue(gaikyoBusiness.get利用施設名());
            gaikyoDiv.getTxtRiyoShisetsuJusho().setValue(gaikyoBusiness.get利用施設住所());
            gaikyoDiv.getTxtTelNo().setValue(gaikyoBusiness.get利用施設電話番号());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtJutakuKaishu().setValue(gaikyoBusiness.get住宅改修_改修箇所());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtTokuBetsuKyufuService().setValue(gaikyoBusiness.get市町村特別給付サービス種類名());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtTokkiZaitakuService().setValue(gaikyoBusiness.get介護保険給付以外の在宅サービス種類名());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtShuso().setValue(gaikyoBusiness.get概況特記事項_主訴());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtKazokuJokyo().setValue(gaikyoBusiness.get概況特記事項_家族状況());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtKyojuKankyo().setValue(gaikyoBusiness.get概況特記事項_居住環境());
            gaikyoDiv.getGaikyoTokkiTextPanel().getTxtKikaiKiki().setValue(gaikyoBusiness.get概況特記事項_機器_器械());
        }
    }

    /**
     * 住宅改修を取得します。
     */
    private void setDataSourcre4(List<RembanServiceJokyoBusiness> serviceJokyos) {
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
}
