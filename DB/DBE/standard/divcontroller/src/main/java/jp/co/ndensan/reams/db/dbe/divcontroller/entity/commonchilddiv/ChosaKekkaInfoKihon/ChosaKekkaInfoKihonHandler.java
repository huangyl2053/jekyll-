/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.ChosaKekkaInfoKihonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfokihon.TokiJikouBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser23;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser30;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser31;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser32;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 認定調査結果情報照会_基本調査の取得するクラスです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public class ChosaKekkaInfoKihonHandler {

    private final ChosaKekkaInfoKihonDiv kihonDiv;
    private static final RString A_99 = new RString("99A");
    private static final RString A_02 = new RString("02A");
    private static final RString A_06 = new RString("06A");
    private static final RString A_09 = new RString("09A");
    private static final RString B_09 = new RString("09B");

    /**
     * コンストラクタです。
     *
     * @param kihonDiv ChosaKekkaInfoKihonDiv
     */
    public ChosaKekkaInfoKihonHandler(ChosaKekkaInfoKihonDiv kihonDiv) {
        this.kihonDiv = kihonDiv;
    }

    /**
     * onLoad処理です。
     *
     * @param chosaKekkaInfoGaikyoList ChosaKekkaInfoKihonBusiness
     * @param serviceJokyos TokiJikouBusiness
     */
    public void onLoad(List<ChosaKekkaInfoKihonBusiness> chosaKekkaInfoGaikyoList, List<TokiJikouBusiness> serviceJokyos) {
        kihonDiv.getTxtNinteichosaJisshiYMD().setDisabled(true);
        kihonDiv.getTxtChosaJisshiBashoMeisho().setDisabled(true);
        kihonDiv.getKihonChosaPanel().getTxtNinchishoNichijoSeikatsuJiritsudoCode().setDisabled(true);
        kihonDiv.getKihonChosaPanel().getTxtShogaiNichijoSeikatsuJiritsudoCode().setDisabled(true);
        kihonDiv.getButton1().setDisabled(false);
        setDataSourcre1(chosaKekkaInfoGaikyoList);
        setDataSourcre2(serviceJokyos);
    }

    /**
     * 利用施設一覧を取得します。
     */
    private void setDataSourcre1(List<ChosaKekkaInfoKihonBusiness> chosaKekkaInfoGaikyoList) {
        if (chosaKekkaInfoGaikyoList != null && !chosaKekkaInfoGaikyoList.isEmpty()) {
            if (chosaKekkaInfoGaikyoList.get(0).get認定調査実施年月日() != null) {
                kihonDiv.getTxtNinteichosaJisshiYMD().setValue(new RDate(chosaKekkaInfoGaikyoList.get(0).get認定調査実施年月日().toString()));
            }
            kihonDiv.getTxtChosaJisshiBashoMeisho().setValue(chosaKekkaInfoGaikyoList.get(0).get認定調査実施場所名称());
            kihonDiv.getKihonChosaPanel().getTxtNinchishoNichijoSeikatsuJiritsudoCode().setValue(NinchishoNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoGaikyoList.get(0).get認定調査_認知症高齢者の日常生活自立度コード().toString())).get名称());
            kihonDiv.getKihonChosaPanel().getTxtShogaiNichijoSeikatsuJiritsudoCode().setValue(ShogaiNichijoSeikatsuJiritsudoCode.
                    toValue(new RString(chosaKekkaInfoGaikyoList.get(0).get認定調査_障害高齢者の日常生活自立度コード().toString())).get名称());
        }
    }

    /**
     * 概況調査_サービス状況を取得します。
     */
    private List<dgKihonChosa_Row> setDataSourcre2(List<TokiJikouBusiness> serviceJokyos) {
        List<dgKihonChosa_Row> grdSinsaSeiList = new ArrayList<>();
        for (TokiJikouBusiness chosaItem : serviceJokyos) {
            dgKihonChosa_Row dgJigyoshaItiran = new dgKihonChosa_Row();
            ArrayList<RString> 認定調査特記事項番号List = new ArrayList<>();
            認定調査特記事項番号List.add(chosaItem.get認定調査特記事項番号());
            dgJigyoshaItiran.setNinteichosaTokkijikoNo(DataPassingConverter.serialize(認定調査特記事項番号List));
            if (A_02.equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン1(dgJigyoshaItiran, chosaItem);
            }
            if (A_06.equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン2(dgJigyoshaItiran, chosaItem);
            }
            if (A_09.equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン3(dgJigyoshaItiran, chosaItem);
            }
            if (A_99.equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン4(dgJigyoshaItiran, chosaItem);
            }
            if (B_09.equals(chosaItem.get厚労省IF識別コード().value())) {
                dgJigyoshaItiran.setKihonResearchItemCode(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get表示番号());
                dgJigyoshaItiran.setKihonResearchItemName(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).get名称());
                setパターン5(dgJigyoshaItiran, chosaItem);
            }
            if (chosaItem.get認定調査特記事項番号() != null && !chosaItem.get認定調査特記事項番号().isEmpty()) {
                dgJigyoshaItiran.getBtnTokkiJiko().setDisabled(false);
            } else {
                dgJigyoshaItiran.getBtnTokkiJiko().setVisible(false);
            }
            grdSinsaSeiList.add(dgJigyoshaItiran);
        }
        kihonDiv.getKihonChosaPanel().getDgKihonChosa().setDataSource(grdSinsaSeiList);
        return grdSinsaSeiList;
    }

    private void setパターン1(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping02A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン2(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping06A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン3(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping09A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン4(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping99A.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }

    private void setパターン5(dgKihonChosa_Row dgJigyoshaItiran, TokiJikouBusiness chosaItem) {
        if (new RString("1").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser01.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("2").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser02.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("3").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser03.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("4").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser04.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("8").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser08.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("9").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser09.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("14").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser14.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("15").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser15.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("16").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser16.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("20").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser20.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("21").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser21.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("22").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser22.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("23").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser23.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("30").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser30.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("31").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser31.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("32").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser32.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("33").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser33.toValue(chosaItem.get調査項目()).get名称());
        }
        if (new RString("34").equals(NinteichosaKomokuMapping09B.toValue(new RString(chosaItem.get連番())).getパターンNo())) {
            dgJigyoshaItiran.setKaitou(ChosaAnser34.toValue(chosaItem.get調査項目()).get名称());
        }
    }
}
