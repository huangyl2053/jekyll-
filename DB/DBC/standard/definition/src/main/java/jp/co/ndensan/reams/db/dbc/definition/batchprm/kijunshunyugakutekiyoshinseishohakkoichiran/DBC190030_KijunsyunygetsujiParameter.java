/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用申請書_異動分作成のバッチ処理フロー
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC190030_KijunsyunygetsujiParameter extends BatchParameterBase {

    private static final String NAME_抽出条件 = "抽出条件";
    private static final String NAME_抽出対象 = "抽出対象";
    private static final String NAME_処理年度 = "処理年度";
    private static final String NAME_被保険者番号 = "被保険者番号";
    private static final String NAME_世帯員把握基準日 = "世帯員把握基準日";
    private static final String NAME_世帯員把握基準日2 = "世帯員把握基準日2";
    private static final String NAME_提出期限 = "提出期限";
    private static final String NAME_作成日 = "作成日";
    private static final String NAME_申請書出力フラグ = "申請書出力フラグ";
    private static final String NAME_お知らせ通知書出力フラグ = "お知らせ通知書出力フラグ";
    private static final String NAME_一覧表CSV出力フラグ = "一覧表CSV出力フラグ";
    private static final String NAME_文書番号 = "文書番号";
    private static final String NAME_帳票出力順ID = "帳票出力順ID";
    private static final String NAME_市町村コード = "市町村コード";
    private static final String NAME_市町村名 = "市町村名";
    private static final String KEY_抽出条件 = "抽出条件";
    private static final String KEY_抽出対象 = "抽出対象";
    private static final String KEY_処理年度 = "処理年度";
    private static final String KEY_被保険者番号 = "被保険者番号";
    private static final String KEY_世帯員把握基準日 = "世帯員把握基準日";
    private static final String KEY_世帯員把握基準日2 = "世帯員把握基準日2";
    private static final String KEY_提出期限 = "提出期限";
    private static final String KEY_作成日 = "作成日";
    private static final String KEY_申請書出力フラグ = "申請書出力フラグ";
    private static final String KEY_お知らせ通知書出力フラグ = "お知らせ通知書出力フラグ";
    private static final String KEY_一覧表CSV出力フラグ = "一覧表CSV出力フラグ";
    private static final String KEY_文書番号 = "文書番号";
    private static final String KEY_帳票出力順ID = "帳票出力順ID";
    private static final String KEY_市町村コード = "市町村コード";
    private static final String KEY_市町村名 = "市町村名";

    @BatchParameter(key = KEY_抽出条件, name = NAME_抽出条件)
    private RString 抽出条件;
    @BatchParameter(key = KEY_抽出対象, name = NAME_抽出対象)
    private RString 抽出対象;
    @BatchParameter(key = KEY_処理年度, name = NAME_処理年度)
    private FlexibleYear 処理年度;
    @BatchParameter(key = KEY_被保険者番号, name = NAME_被保険者番号)
    private HihokenshaNo 被保険者番号;
    @BatchParameter(key = KEY_世帯員把握基準日, name = NAME_世帯員把握基準日)
    private FlexibleDate 世帯員把握基準日;
    @BatchParameter(key = KEY_世帯員把握基準日2, name = NAME_世帯員把握基準日2)
    private FlexibleDate 世帯員把握基準日2;
    @BatchParameter(key = KEY_提出期限, name = NAME_提出期限)
    private RString 提出期限;
    @BatchParameter(key = KEY_作成日, name = NAME_作成日)
    private FlexibleDate 作成日;
    @BatchParameter(key = KEY_申請書出力フラグ, name = NAME_申請書出力フラグ)
    private Boolean 申請書出力フラグ;
    @BatchParameter(key = KEY_お知らせ通知書出力フラグ, name = NAME_お知らせ通知書出力フラグ)
    private Boolean お知らせ通知書出力フラグ;
    @BatchParameter(key = KEY_一覧表CSV出力フラグ, name = NAME_一覧表CSV出力フラグ)
    private Boolean 一覧表CSV出力フラグ;
    @BatchParameter(key = KEY_文書番号, name = NAME_文書番号)
    private RString 文書番号;
    @BatchParameter(key = KEY_帳票出力順ID, name = NAME_帳票出力順ID)
    private Long 帳票出力順ID;
    @BatchParameter(key = KEY_市町村コード, name = NAME_市町村コード)
    private LasdecCode 市町村コード;
    @BatchParameter(key = KEY_市町村名, name = NAME_市町村名)
    private RString 市町村名;

}
