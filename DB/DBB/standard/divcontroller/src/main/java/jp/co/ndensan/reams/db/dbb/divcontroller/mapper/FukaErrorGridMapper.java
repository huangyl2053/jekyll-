/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.mapper;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.FukaError;
import jp.co.ndensan.reams.db.dbb.business.FukaErrorReportItem;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0020002.dgFukaErrorList_Row;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 賦課エラー一覧グリッドと、対応するビジネスクラスをマッピングするクラスです。
 *
 * @author n8178 城間篤人
 */
public final class FukaErrorGridMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private FukaErrorGridMapper() {
    }

    /**
     * 賦課エラー一覧が持つデータを引数から受け取り、グリッドに値を設定できる形にマッピングして返します。
     *
     * @param reportItemList 賦課エラー一覧が持つデータ
     * @return グリッドに設定できるDataSource
     */
    public static List<dgFukaErrorList_Row> toFukaErrorListGrid(List<FukaErrorReportItem> reportItemList) {
        List<dgFukaErrorList_Row> list = new ArrayList<>();
        for (FukaErrorReportItem reportItem : reportItemList) {
            list.add(toFukaErrorListRow(reportItem));
        }
        return list;
    }

    /**
     * グリッドのDataSourceを受け取り、賦課エラー一覧のデータにマッピングします。
     *
     * @param dataSource グリッドのDataSource
     * @return 賦課エラー一覧のデータ
     */
    public static List<FukaErrorReportItem> toFukaErrorReportItemList(List<dgFukaErrorList_Row> dataSource) {
        List<FukaErrorReportItem> list = new ArrayList<>();
        for (dgFukaErrorList_Row row : dataSource) {
            list.add(toFukaErrorReportItem(row));
        }
        return list;
    }

    /**
     * 賦課エラー一覧の1行分のデータを受け取り、グリッドのDataSource1行分にマッピングします。
     *
     * @param reportItem 賦課エラー一覧の1行分のデータ
     * @return グリッドのDataSource1行分
     */
    public static dgFukaErrorList_Row toFukaErrorListRow(FukaErrorReportItem reportItem) {
        dgFukaErrorList_Row row = new dgFukaErrorList_Row(RString.EMPTY, RString.EMPTY, new TextBoxDate(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
        row.getFukaNendo().setValue(new RDate(reportItem.get賦課年度().getYearValue()));
        row.setTsuchishoNo(reportItem.get通知書番号());
        row.setErrorCode(reportItem.getエラー内容().getFukaErrorCode().value());
        row.setErrorDetail(reportItem.getエラー内容().getMeisho());
        row.setHihokenshaNo(reportItem.get被保険者番号().getColumnValue());
        row.setShikibetsuCode(reportItem.get識別コード().getColumnValue());
        row.setShoriJokyoCode(reportItem.getShoriKubun().getCode().value());
        row.setShoriJokyo(reportItem.getShoriKubun().getState());
        return row;
    }

    /**
     * グリッドのDataSource1行分を、賦課エラー一覧の1行分のデータにマッピングします。
     *
     * @param row グリッドのDataSource1行分
     * @return 賦課エラー一覧1行分のデータ
     */
    public static FukaErrorReportItem toFukaErrorReportItem(dgFukaErrorList_Row row) {
        FukaErrorReportItem reportItem = new FukaErrorReportItem(row.getFukaNendo().getValue().getYear(),
                row.getTsuchishoNo(),
                new FukaError(new Code(row.getErrorCode()), row.getErrorDetail(), row.getErrorDetail()),
                new KaigoHihokenshaNo(row.getHihokenshaNo()),
                new ShikibetsuCode(row.getShikibetsuCode()),
                InternalReportShoriKubun.toValue(new Code(row.getShoriJokyoCode())));
        return reportItem;
    }
}
