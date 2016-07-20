/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6050001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenshoHoshuShokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ikenshohoshushokai.IkenHoshuIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ikenshohoshushokaiichiran.IkenshoHoshuShokaiIchiranKey;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.IkenshoSakuseiHoshuShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001.dgIkenshoSakuseiHoshu_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 意見書作成報酬照会の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1930-010 chenxiangyu
 */
public class IkenshoSakuseiHoshuShokaiHandler {

    private static final RString MARO = new RString("○");
    private static final RString 一覧表を発行する = new RString("btnPulish");
    private static final RString CSVを出力する = new RString("btnShutsutyoku");
    private static final RString 条件に戻る = new RString("btnModoru");
    private final IkenshoSakuseiHoshuShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public IkenshoSakuseiHoshuShokaiHandler(IkenshoSakuseiHoshuShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期状態の設定です。
     */
    public void set初期状態() {
        div.getIkenshoSakuseiHoshu().setDisplayNone(true);
        div.getSakuseiIraibi().setDisplayNone(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(一覧表を発行する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, false);
    }

    /**
     * 画面一覧状態の設定です。
     */
    public void set一覧状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(一覧表を発行する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, true);
        div.getSakuseiIraibi().setDisplayNone(true);
        div.getIkenshoSakuseiHoshu().setDisplayNone(false);
    }

    /**
     * 一覧結果を設定です。
     *
     * @param ikenshoHoshuShokaiBusinessList 意見書作成報酬照会
     */
    public void set一覧結果(List<IkenshoHoshuShokaiBusiness> ikenshoHoshuShokaiBusinessList) {
        Decimal txtZaitakuShinki = Decimal.ZERO;
        Decimal txtZaitakuKeizoku = Decimal.ZERO;
        Decimal txtShisetsuShinki = Decimal.ZERO;
        Decimal txtShisetsuKeizoku = Decimal.ZERO;
        Decimal txtKotsuhito = Decimal.ZERO;
        Decimal txtZeiKojoGaku = Decimal.ZERO;
        Decimal txtHoshuGokei = Decimal.ZERO;
        List<dgIkenshoSakuseiHoshu_Row> row_list = new ArrayList<>();
        for (IkenshoHoshuShokaiBusiness date : ikenshoHoshuShokaiBusinessList) {
            AccessLogger.log(AccessLogType.照会, this.toPersonalData(date.get申請書管理番号()));
            dgIkenshoSakuseiHoshu_Row row = new dgIkenshoSakuseiHoshu_Row();
            row.setIryoKikanCode(date.get主治医医療機関コード());
            row.setIryoKikanMei(date.get医療機関名称());
            row.setCode(date.get主治医コード());
            row.setShujiiShimei(date.get主治医氏名());
            if (date.get主治医意見書作成依頼年月日() != null) {
                row.setIraibi(toTextBoxDate(date.get主治医意見書作成依頼年月日().toString()));
            }
            if (date.get主治医意見書記入年月日() != null) {
                row.setKinyubi(toTextBoxDate(date.get主治医意見書記入年月日().toString()));
            }
            if (date.get主治医意見書受領年月日() != null) {
                row.setNyushubi(toTextBoxDate(date.get主治医意見書受領年月日().toString()));
            }
            if (NinteiChousaIraiKubunCode.初回.getコード().equals(date.get主治医意見書依頼区分())) {
                row.setIkenshoIraiKubun(new RString("初"));
            } else {
                row.setIkenshoIraiKubun(new RString("再"));
            }
            row.setHokenshaBango(date.get証記載保険者番号());
            row.setHihokenshaBango(date.get被保険者番号());
            row.setShinseishaShimei(date.get被保険者氏名());
            row.setZaitakuShin(date.get在宅_新());
            if (date.get在宅_新().equals(MARO)) {
                txtZaitakuShinki = txtZaitakuShinki.add(Decimal.ONE);
            }
            row.setZaitakuKe(date.get在宅_継());
            if (date.get在宅_継().equals(MARO)) {
                txtZaitakuKeizoku = txtZaitakuKeizoku.add(Decimal.ONE);
            }
            row.setShisetsuShin(date.get施設_新());
            if (date.get施設_新().equals(MARO)) {
                txtShisetsuShinki = txtShisetsuShinki.add(Decimal.ONE);
            }
            row.setShisetsuKe(date.get施設_継());
            if (date.get施設_継().equals(MARO)) {
                txtShisetsuKeizoku = txtShisetsuKeizoku.add(Decimal.ONE);
            }
            txtKotsuhito = txtKotsuhito.add(date.get主治医意見書作成料());
            row.setSakuseiryo(DecimalFormatter.toコンマ区切りRString(new Decimal(date.get主治医意見書作成料()), 0).concat("円"));
            txtZeiKojoGaku = txtZeiKojoGaku.add(date.get主治医意見書別途診療費());
            row.setShinryohito(DecimalFormatter.toコンマ区切りRString(new Decimal(date.get主治医意見書別途診療費()), 0).concat("円"));
            txtHoshuGokei = txtHoshuGokei.add(date.get主治医意見書報酬());
            row.setGokei(DecimalFormatter.toコンマ区切りRString(new Decimal(date.get主治医意見書報酬()), 0).concat("円"));
            row.setShinseishoKanriNo(date.get申請書管理番号());
            row.setIkenshoIraiRirekiNo(new RString(date.get主治医意見書作成依頼履歴番号()));
            row_list.add(row);
        }
        div.getTxtZaitakuShinki().setValue(txtZaitakuShinki);
        div.getTxtZaitakuKeizoku().setValue(txtZaitakuKeizoku);
        div.getTxtShisetsuShinki().setValue(txtShisetsuShinki);
        div.getTxtShisetsuKeizoku().setValue(txtShisetsuKeizoku);
        div.getTxtKotsuhito().setValue(txtKotsuhito);
        div.getTxtZeiKojoGaku().setValue(txtZeiKojoGaku);
        div.getTxtHoshuGokei().setValue(txtHoshuGokei);
        div.getDgIkenshoSakuseiHoshu().setDataSource(row_list);
    }

    /**
     * バッチパラメータの作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return 意見書作成報酬照会の合計額リスト_バッチフロークラスパラメータ
     */
    public IkenHoshuIchiranBatchParameter createBatchParam(RString 帳票出力区分) {
        List<IkenshoHoshuShokaiIchiranKey> keyJohoList = new ArrayList<>();
        for (dgIkenshoSakuseiHoshu_Row row : div.getDgIkenshoSakuseiHoshu().getDataSource()) {
            if (row.getSelected()) {
                IkenshoHoshuShokaiIchiranKey key = new IkenshoHoshuShokaiIchiranKey(
                        row.getIryoKikanCode(),
                        row.getCode(),
                        row.getShinseishoKanriNo(),
                        Integer.parseInt(row.getIkenshoIraiRirekiNo().toString()));
                keyJohoList.add(key);
            }
        }
        FlexibleDate 作成依頼日開始 = FlexibleDate.EMPTY;
        FlexibleDate 作成依頼日終了 = FlexibleDate.EMPTY;
        if (div.getTxtSakuseiIraibi().getFromValue() != null) {
            作成依頼日開始 = new FlexibleDate(div.getTxtSakuseiIraibi().getFromValue().toDateString());
        }
        if (div.getTxtSakuseiIraibi().getToValue() != null) {
            作成依頼日終了 = new FlexibleDate(div.getTxtSakuseiIraibi().getToValue().toDateString());
        }
        return new IkenHoshuIchiranBatchParameter(帳票出力区分, 作成依頼日開始, 作成依頼日終了, keyJohoList);
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private TextBoxDate toTextBoxDate(String dateString) {
        TextBoxDate textBoxDate = new TextBoxDate();
        textBoxDate.setValue(new RDate(dateString));
        return textBoxDate;
    }

    /**
     * 作成依頼日をクリアします。
     */
    public void clear作成依頼日() {
        div.getTxtSakuseiIraibi().clearFromValue();
        div.getTxtSakuseiIraibi().clearToValue();
    }

    /**
     * 初期最大取得件数を設定です。
     */
    public void set初期最大取得件数() {
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
    }
}
