/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6060001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteichosahoshushokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.DBE601005_NinteichosaHoshuParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.NinteiChosaHoshuShokaiFlowBusiness;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.NinteiChosaHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6060001.dgNinteiChosaHoshu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

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
    private static final RString 広域 = new RString("211");

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
            row.setHokensha(get保険者(調査一覧));
            row.setChosainCode(調査一覧.get認定調査員コード());
            row.setChosainShimei(調査一覧.get調査員氏名());
            row.setChosakikanCode(調査一覧.get認定調査委託先コード());
            row.setChosakikanMei(調査一覧.get事業者名称());
            row.setHihokenshaBango(調査一覧.get被保険者番号());
            row.setHokenshaBango(調査一覧.get証記載保険者番号());
            row.setNinteichosaIraiRirekiNo(new RString(調査一覧.get認定調査依頼履歴番号()));
            row.setShinseishoKanriNo(調査一覧.get申請書管理番号().getColumnValue());
            if (!調査一覧.get認定調査依頼年月日().isEmpty()) {
                row.getIraibi().setValue(new RDate(調査一覧.get認定調査依頼年月日().getYearValue(),
                        調査一覧.get認定調査依頼年月日().getMonthValue(),
                        調査一覧.get認定調査依頼年月日().getDayValue()));
            }
            if (!調査一覧.get認定調査受領年月日().isEmpty()) {
                row.getNyushubi().setValue(new RDate(調査一覧.get認定調査受領年月日().getYearValue(),
                        調査一覧.get認定調査受領年月日().getMonthValue(), 調査一覧.get認定調査受領年月日().getDayValue()));
            }
            if (!調査一覧.get認定調査実施年月日().isEmpty()) {
                row.getChosabi().setValue(new RDate(調査一覧.get認定調査実施年月日().getYearValue(),
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
                row.setZaitakuSho(項目状態);
                在宅_初 = 在宅_初 + 1;
            }
            if (ChosaKubun.再調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setZaitakuSai(項目状態);
                在宅_再 = 在宅_再 + 1;
            }
            if (ChosaKubun.新規調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && !ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setShisetsuSho(項目状態);
                施設_初 = 施設_初 + 1;
            }
            if (ChosaKubun.再調査.getコード().equals(調査一覧.get認定調査区分コード().value())
                    && !ChosaJisshiBashoCode.自宅内.getコード().equals(調査一覧.get認定調査実施場所コード().value())) {
                row.setShisetsuSai(項目状態);
                施設_再 = 施設_再 + 1;
            }
            row.setItakuryo(DecimalFormatter.toコンマ区切りRString(new Decimal(調査一覧.get認定調査委託料()), 0));
            if (!調査一覧.get認定調査受領年月日().isEmpty()) {
                委託料 = 委託料.add(new Decimal(調査一覧.get認定調査委託料()));
            }
            listRow.add(row);
            アクセスログ(調査一覧.get申請書管理番号().getColumnValue());
        }
        div.getDgNinteiChosaHoshu().setDataSource(listRow);
        div.getTxtZaitakuSaichosa().setValue(new Decimal(在宅_再));
        div.getTxtZaitakuShokai().setValue(new Decimal(在宅_初));
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
    public DBE601005_NinteichosaHoshuParameter getTempData(RString 出力区分) {
        DBE601005_NinteichosaHoshuParameter tempData = new DBE601005_NinteichosaHoshuParameter();
        RString 依頼日開始 = RString.EMPTY;
        RString 依頼日終了 = RString.EMPTY;
        if (div.getTxtChosaIraibi().getFromValue() != null) {
            依頼日開始 = div.getTxtChosaIraibi().getFromValue().toDateString();
        }
        if (div.getTxtChosaIraibi().getToValue() != null) {
            依頼日終了 = div.getTxtChosaIraibi().getToValue().toDateString();
        }
        List<NinteiChosaHoshuShokaiFlowBusiness> 情報 = new ArrayList<>();
        List<dgNinteiChosaHoshu_Row> list = div.getDgNinteiChosaHoshu().getDataSource();
        for (dgNinteiChosaHoshu_Row rowList : list) {
            if (rowList.getSelected()) {
                NinteiChosaHoshuShokaiFlowBusiness business = new NinteiChosaHoshuShokaiFlowBusiness();
                business.set認定調査員コード(rowList.getChosainCode());
                business.set認定調査委託先コード(rowList.getChosakikanCode());
                business.set申請書管理番号(rowList.getShinseishoKanriNo());
                business.set認定調査依頼履歴番号(Integer.parseInt(rowList.getNinteichosaIraiRirekiNo().toString()));
                情報.add(business);
            }
        }
        tempData.set帳票出力区分(出力区分);
        tempData.set情報リスト(情報);
        tempData.set調査依頼日開始(依頼日開始);
        tempData.set調査依頼日終了(依頼日終了);
        tempData.setHokensya(div.getChosaIraibi().getCcdHokensya().getSelectedItem().get市町村コード().value());
        tempData.setHokenshaName(div.getChosaIraibi().getCcdHokensya().getSelectedItem().get市町村名称());
        return tempData;
    }

    private RString get保険者(NinteichosahoshushokaiBusiness 調査情報) {
        return nullToEmpty(調査情報.get市町村名称());

    }

    private RString nullToEmpty(RString str) {
        return str == null ? RString.EMPTY : str;
    }

    /**
     * 広域か単一か判定します。
     *
     * @return 広域の場合 True 単一の場合 False
     */
    public boolean is広域() {
        ShichosonSecurityJoho 市町村情報
                = jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (市町村情報 != null && 市町村情報.get導入形態コード() != null) {
            return 市町村情報.get導入形態コード().getColumnValue().equals(広域);
        }
        return false;
    }

    /**
     * 市町村名を返します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        return 導入団体クラス.get市町村名();
    }
}
