/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6060001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteichosahoshushokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuGoKeFlowBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiFlowBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai.NinteiChosaHoshuShokaiFlowParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.NinteiChosaHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.dgNinteiChosaHoshu_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査報酬照会のハンドラークラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteiChosaHoshuShokaiHandler {

    private final NinteiChosaHoshuShokaiDiv div;
    private static final Code SHIKI = new Code("0001");
    private static final RString 管理番号 = new RString("申請書管理番号");
    private static final RString 項目状態 = new RString("○");
    private static final RString 帳票出力区分 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div NinteiChosaHoshuShokaiDiv
     */
    public NinteiChosaHoshuShokaiHandler(NinteiChosaHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査報酬照会の検索処理です。
     *
     * @param 調査情報 List<NinteichosahoshushokaiBusiness>
     */
    public void onClick_btnKensaku(List<NinteichosahoshushokaiBusiness> 調査情報) {
        List<dgNinteiChosaHoshu_Row> listRow = new ArrayList();
        int 在宅_初 = 0;
        int 在宅_再 = 0;
        int 施設_初 = 0;
        int 施設_再 = 0;
        Decimal 委託料 = Decimal.ZERO;
        for (NinteichosahoshushokaiBusiness 調査一覧 : 調査情報) {
            dgNinteiChosaHoshu_Row row = new dgNinteiChosaHoshu_Row();
            row.setChosainCode(調査一覧.get認定調査員コード());
            row.setChosainShimei(調査一覧.get調査員氏名());
            row.setChosakikanCode(調査一覧.get認定調査委託先コード());
            row.setChosakikanMei(調査一覧.get事業者名称());
            row.setHihokenshaBango(調査一覧.get被保険者番号());
            row.setHokenshaBango(調査一覧.get証記載保険者番号());
            if (!調査一覧.get認定調査依頼年月日().isEmpty()) {
                row.getIraibi().setValue(new RDate(調査一覧.get認定調査依頼年月日().getYearValue(),
                        調査一覧.get認定調査依頼年月日().getMonthValue(),
                        調査一覧.get認定調査依頼年月日().getDayValue()));
            }
            if (!調査一覧.get認定調査受領年月日().isEmpty()) {
                row.getChosabi().setValue(new RDate(調査一覧.get認定調査受領年月日().getYearValue(),
                        調査一覧.get認定調査受領年月日().getMonthValue(), 調査一覧.get認定調査受領年月日().getDayValue()));
            }
            if (!調査一覧.get認定調査実施年月日().isEmpty()) {
                row.getNyushubi().setValue(new RDate(調査一覧.get認定調査実施年月日().getYearValue(),
                        調査一覧.get認定調査実施年月日().getMonthValue(), 調査一覧.get認定調査実施年月日().getDayValue()));
            }
            if (NinteiChousaIraiKubunCode.初回.getコード().equals(調査一覧.get認定調査依頼区分コード().value())) {
                row.setNinteiChousaIraiKubunCode(new RString("初"));
            } else {
                row.setNinteiChousaIraiKubunCode(new RString("再"));
            }
            row.setShinseishaShimei(調査一覧.get被保険者氏名().getColumnValue());
            if (ChosaKubun.新規調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setShisetsuSai(項目状態);
                在宅_初 = 在宅_初 + 1;
            }
            if (ChosaKubun.再調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setShisetsuSho(項目状態);
                在宅_再 = 在宅_再 + 1;
            }
            if (ChosaKubun.新規調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && !ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setZaitakuSai(項目状態);
                施設_初 = 施設_初 + 1;
            }
            if (ChosaKubun.再調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && !ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setZaitakuSho(項目状態);
                施設_再 = 施設_再 + 1;
            }
            row.getItakuryo().setValue(new Decimal(調査一覧.get認定調査委託料()));
            委託料 = 委託料.add(new Decimal(調査一覧.get認定調査委託料()));
            listRow.add(row);
            アクセスログ(調査一覧.get申請書管理番号().getColumnValue());
        }
        div.getDgNinteiChosaHoshu().setDataSource(listRow);
        div.getTxtZaitakuSaichosa().setValue(new Decimal(在宅_初));
        div.getTxtZaitakuShokai().setValue(new Decimal(在宅_再));
        div.getTxtShisetsuShokai().setValue(new Decimal(施設_初));
        div.getTxtShisetsuSaichosa().setValue(new Decimal(施設_再));
        div.getTxtItakuryoGokei().setValue(委託料);
    }

    private void アクセスログ(RString 申請書管理番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(SHIKI, 管理番号,
                申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    /**
     * バッチパラメータの設定です。
     *
     * @param 出力区分 RString
     * @return NinteiChosaHoshuShokaiFlowParameter
     */
    public NinteiChosaHoshuShokaiFlowParameter getTempData(RString 出力区分) {
        NinteiChosaHoshuShokaiFlowParameter tempData = new NinteiChosaHoshuShokaiFlowParameter();
        FlexibleDate 依頼日開始 = new FlexibleDate(div.getTxtChosaIraibi().getFromValue().toDateString());
        FlexibleDate 依頼日終了 = new FlexibleDate(div.getTxtChosaIraibi().getToValue().toDateString());
        List<NinteiChosaHoshuShokaiFlowBusiness> 情報 = new ArrayList<>();
        List<dgNinteiChosaHoshu_Row> list = div.getDgNinteiChosaHoshu().getDataSource();
        NinteiChosaHoshuGoKeFlowBusiness gokeBusiness = new NinteiChosaHoshuGoKeFlowBusiness();
        int 在宅_初 = 0;
        int 在宅_再 = 0;
        int 施設_初 = 0;
        int 施設_再 = 0;
        Decimal 委託料 = Decimal.ZERO;
        for (dgNinteiChosaHoshu_Row rowList : list) {
            if (rowList.getSelected()) {
                NinteiChosaHoshuShokaiFlowBusiness business = new NinteiChosaHoshuShokaiFlowBusiness();
                business.set認定調査員コード(rowList.getChosainCode());
                business.set認定調査委託先コード(rowList.getChosakikanCode());
                business.set在宅_再(rowList.getZaitakuSai());
                business.set在宅_初(rowList.getZaitakuSho());
                business.set施設_再(rowList.getShisetsuSai());
                business.set施設_初(rowList.getShisetsuSho());
                business.set事業者名称(rowList.getChosakikanMei());
                business.set被保険者氏名(rowList.getShinseishaShimei());
                business.set調査員氏名(rowList.getChosainShimei());
                business.set被保険者番号(rowList.getHihokenshaBango());
                business.set証記載保険者番号(rowList.getHokenshaBango());
                business.set認定調査依頼区分コード(rowList.getNinteiChousaIraiKubunCode());
                business.set認定調査依頼年月日(rowList.getIraibi().getValue());
                business.set認定調査受領年月日(rowList.getChosabi().getValue());
                business.set認定調査実施年月日(rowList.getNyushubi().getValue());
                business.set認定調査委託料(rowList.getItakuryo().getValue().intValue());
                情報.add(business);
            }
        }
        if (帳票出力区分.equals(出力区分)) {
            gokeBusiness.set調査依頼日終了(依頼日終了);
            gokeBusiness.set調査依頼日開始(依頼日開始);
            for (dgNinteiChosaHoshu_Row rowList : list) {
                if (rowList.getSelected() && 項目状態.equals(rowList.getZaitakuSho())) {
                    在宅_初 = 在宅_初 + 1;
                }
                if (rowList.getSelected() && 項目状態.equals(rowList.getZaitakuSai())) {
                    在宅_再 = 在宅_再 + 1;
                }
                if (rowList.getSelected() && 項目状態.equals(rowList.getShisetsuSho())) {
                    施設_初 = 施設_初 + 1;
                }
                if (rowList.getSelected() && 項目状態.equals(rowList.getShisetsuSai())) {
                    施設_再 = 施設_再 + 1;
                }
                if (rowList.getSelected()) {
                    委託料 = 委託料.add(rowList.getItakuryo().getValue());
                }
            }
            gokeBusiness.set在宅初回(在宅_初);
            gokeBusiness.set在宅再調査(在宅_再);
            gokeBusiness.set施設初回(施設_初);
            gokeBusiness.set施設再調査(施設_再);
            gokeBusiness.set委託料合計(委託料.intValue());
        }

        tempData.set帳票出力区分(出力区分);
        tempData.set情報リスト(情報);
        tempData.set合計情報(gokeBusiness);
        return tempData;
    }
}
