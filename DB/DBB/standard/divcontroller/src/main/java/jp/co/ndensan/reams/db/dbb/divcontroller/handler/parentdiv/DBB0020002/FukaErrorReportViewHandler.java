/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0020002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorListBuilder;
import jp.co.ndensan.reams.db.dbb.business.report.fukaerror.FukaErrorListCsvItem;
import jp.co.ndensan.reams.db.dbb.business.report.fukaerror.FukaErrorListCsvItemList;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.ErrorCode;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorReportViewDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.FukaErrorShoriButtonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 賦課エラー一覧のHandlerクラスです。
 *
 * @reamsid_L DBB-0720-010 zuotao
 */
public class FukaErrorReportViewHandler {

    private final FukaErrorReportViewDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 賦課エラー情報Div
     */
    public FukaErrorReportViewHandler(FukaErrorReportViewDiv div) {
        this.div = div;
    }

    /**
     * 賦課エラー画面初期表示します。
     *
     * @param 賦課エラー情報 賦課エラー情報
     */
    public void initialize(List<FukaErrorList> 賦課エラー情報) {
        set賦課エラー情報(賦課エラー情報);
        setButtonDisplayNone();
    }

    /**
     * グリッドのDataSourceを受け取り、賦課エラー一覧のデータにマッピングします。
     *
     * @return 賦課エラー一覧のデータ
     */
    public FukaErrorListCsvItemList toFukaErrorReportItemList() {
        List<FukaErrorListCsvItem> list = new ArrayList<>();
        for (dgFukaErrorList_Row row : div.getDgFukaErrorList().getDataSource()) {
            list.add(toFukaErrorReportItem(row));
        }
        return new FukaErrorListCsvItemList(list);
    }

    /**
     * グリッドのDataSource1行分を、賦課エラー一覧の1行分のデータにマッピングします。
     *
     * @param row グリッドのDataSource1行分
     * @return 賦課エラー一覧1行分のデータ
     */
    public FukaErrorListCsvItem toFukaErrorReportItem(dgFukaErrorList_Row row) {
        FukaErrorList fukaErrorList = new FukaErrorList(
                new SubGyomuCode(row.getSubGyomuCode()),
                row.getNaibuChohyoId(),
                new FlexibleYear(row.getFukaNendo().getValue().getYear().toDateString()),
                new TsuchishoNo(row.getTsuchishoNo()));
        FukaErrorListBuilder builder = fukaErrorList.createBuilderForEdit();
        builder.setエラーコード(new Code(row.getErrorCode()));
        builder.set処理区分コード(new Code(row.getShoriJokyoCode()));
        builder.set被保険者番号(new HihokenshaNo(row.getHihokenshaNo()));
        builder.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
        return new FukaErrorListCsvItem(builder.build());
    }

    /**
     * 選択した行のエラー内容に合わせて、修正処理へ遷移するボタンの表示非表示を切り替え、遷移可能な状態に切り替えます。
     */
    public void onSelect_dgFukaErrorList() {
        FukaErrorShoriButtonDiv buttonDiv = div.getFukaErrorShoriButton();
        setButtonDisplayNone();
        dgFukaErrorList_Row row = div.getDgFukaErrorList().getSelectedItems().get(0);
        if (ErrorCode.被保険者台帳データなし.getコード().equals(row.getErrorCode())
                || ErrorCode.資格と住基に不整合あり.getコード().equals(row.getErrorCode())) {
            buttonDiv.getBtnShikakuFuseigo().setDisplayNone(false);
        } else if (ErrorCode.世帯員所得データなし.getコード().equals(row.getErrorCode())
                || ErrorCode.賦課に減免あり.getコード().equals(row.getErrorCode())) {
            buttonDiv.getBtnFukaKosei().setDisplayNone(false);
        } else {
            setButtonDisplayNone();
        }
        buttonDiv.getBtnMishori().setDisplayNone(false);
        buttonDiv.setDisabled(false);
    }

    private void set賦課エラー情報(List<FukaErrorList> 賦課エラー情報) {
        List<dgFukaErrorList_Row> dataSource = new ArrayList<>();
        for (FukaErrorList fukaErrorList : 賦課エラー情報) {
            dgFukaErrorList_Row row = new dgFukaErrorList_Row();
            if (fukaErrorList.get処理区分コード() != null && !RString.EMPTY.equals(fukaErrorList.get処理区分コード().getKey())) {
                row.setShoriJokyoCode(fukaErrorList.get処理区分コード().getKey());
                row.setShoriJokyo(new RString(InternalReportShoriKubun.toValue(fukaErrorList.get処理区分コード()).name()));
            }
            if (fukaErrorList.get賦課年度() != null) {
                row.getFukaNendo().setValue(new RDate(fukaErrorList.get賦課年度().toString()));
            }
            if (fukaErrorList.get通知書番号() != null) {
                row.setTsuchishoNo(fukaErrorList.get通知書番号().value());
            }
            if (fukaErrorList.getエラーコード() != null) {
                row.setErrorCode(fukaErrorList.getエラーコード().getKey());
                row.setErrorDetail(CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課,
                        DBBCodeShubetsu.エラーコード.getコード(), fukaErrorList.getエラーコード(), FlexibleDate.getNowDate()));
            }
            if (fukaErrorList.get被保険者番号() != null) {
                row.setHihokenshaNo(fukaErrorList.get被保険者番号().value());
            }
            if (fukaErrorList.get識別コード() != null) {
                row.setShikibetsuCode(fukaErrorList.get識別コード().value());
            }
            row.setSubGyomuCode(fukaErrorList.getサブ業務コード().value());
            row.setNaibuChohyoId(fukaErrorList.get内部帳票ID());
            dataSource.add(row);
        }
        div.getDgFukaErrorList().setDataSource(dataSource);
    }

    private void setButtonDisplayNone() {
        div.getFukaErrorShoriButton().getBtnFukaKosei().setDisplayNone(true);
        div.getFukaErrorShoriButton().getBtnShikakuFuseigo().setDisplayNone(true);
        div.getFukaErrorShoriButton().getBtnMishori().setDisplayNone(true);
    }
}
