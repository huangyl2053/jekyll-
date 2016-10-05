/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.DBB015003_KarisanteiIdoTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB015003.TyouhyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票一覧のクラスです。
 *
 * @reamsid_L DBB-0890-020 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB015001_KarisanteiIdoFukaParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_処理対象月 = "処理対象月";
    private static final String KEY_普徴仮算定異動方法 = "普徴仮算定異動方法";
    private static final String KEY_抽出開始日時 = "抽出開始日時";
    private static final String KEY_抽出終了日時 = "抽出終了日時";
    private static final String KEY_帳票グループ = "帳票グループ";
    private static final String KEY_出力帳票一覧 = "KEY_出力帳票一覧";
    private static final String KEY_特徴_発行日 = "特徴_発行日";
    private static final String KEY_仮算定額変更_発行日 = "仮算定額変更_発行日";
    private static final String KEY_文書番号 = "文書番号";
    private static final String KEY_納入_出力期 = "納入_出力期";
    private static final String KEY_納入_出力方式 = "納入_出力方式";
    private static final String KEY_納入_発行日 = "納入_発行日";
    private static final String KEY_納入_対象者 = "納入_対象者";
    private static final String KEY_納入_生活保護対象者 = "活保護対象者";
    private static final String KEY_納入_ページごとに山分け = "納入_ページごとに山分け";
    private static final String KEY_特徴仮算定賦課処理日時 = "特徴仮算定賦課処理日時";
    private static final String KEY_普徴仮算定賦課処理日時 = "普徴仮算定賦課処理日時";
    private static final String KEY_一括発行起動フラグ = "一括発行起動フラグ";
    private static final String KEY_特徴捕捉対象者の依頼金額計算区分 = "特徴捕捉対象者の依頼金額計算区分";
    private static final String KEY_算定期 = "算定期";
    private static final String KEY_バッチ起動フラグ = "バッチ起動フラグ";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private RString 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private RString 賦課年度;
    @BatchParameter(key = KEY_処理対象月, name = "処理対象月")
    private RString 処理対象月;
    @BatchParameter(key = KEY_普徴仮算定異動方法, name = "普徴仮算定異動方法")
    private RString 普徴仮算定異動方法;
    @BatchParameter(key = KEY_抽出開始日時, name = "抽出開始日時")
    private RString 抽出開始日時;
    @BatchParameter(key = KEY_抽出終了日時, name = "抽出終了日時")
    private RString 抽出終了日時;
    @BatchParameter(key = KEY_帳票グループ, name = "帳票グループ")
    private RString 帳票グループ;
    @BatchParameter(key = KEY_出力帳票一覧, name = "出力帳票一覧")
    private List<TyouhyouEntity> 出力帳票一覧List;
    @BatchParameter(key = KEY_特徴_発行日, name = "特徴_発行日")
    private RString 特徴_発行日;
    @BatchParameter(key = KEY_仮算定額変更_発行日, name = "仮算定額変更_発行日")
    private RString 仮算定額変更_発行日;
    @BatchParameter(key = KEY_文書番号, name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = KEY_納入_出力期, name = "納入_出力期")
    private RString 納入_出力期;
    @BatchParameter(key = KEY_納入_出力方式, name = "納入_出力方式")
    private RString 納入_出力方式;
    @BatchParameter(key = KEY_納入_発行日, name = "納入_発行日")
    private RString 納入_発行日;
    @BatchParameter(key = KEY_納入_対象者, name = "納入_対象者")
    private RString 納入_対象者;
    @BatchParameter(key = KEY_納入_生活保護対象者, name = "納入_生活保護対象者")
    private RString 納入_生活保護対象者;
    @BatchParameter(key = KEY_納入_ページごとに山分け, name = "ページごとに山分け")
    private RString 納入_ページごとに山分け;
    @BatchParameter(key = KEY_特徴仮算定賦課処理日時, name = "特徴仮算定賦課処理日時")
    private RString 特徴仮算定賦課処理日時;
    @BatchParameter(key = KEY_普徴仮算定賦課処理日時, name = "普徴仮算定賦課処理日時")
    private RString 普徴仮算定賦課処理日時;
    @BatchParameter(key = KEY_一括発行起動フラグ, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;
    @BatchParameter(key = KEY_特徴捕捉対象者の依頼金額計算区分, name = "特徴捕捉対象者の依頼金額計算区分")
    private RString 特徴捕捉対象者の依頼金額計算区分;
    @BatchParameter(key = KEY_算定期, name = "算定期")
    private RString 算定期;
    @BatchParameter(key = KEY_バッチ起動フラグ, name = "バッチ起動フラグ")
    private boolean バッチ起動フラグ;

    /**
     * 仮算定異動通知書一括発行のバッチパラメータです。
     *
     * @return DBB015003_KarisanteiIdoTsuchishoHakkoParameter
     */
    public DBB015003_KarisanteiIdoTsuchishoHakkoParameter toDBB015003_KarisanteiIdoTsuchishoHakkoParameter() {
        DBB015003_KarisanteiIdoTsuchishoHakkoParameter dbb015003 = new DBB015003_KarisanteiIdoTsuchishoHakkoParameter();
        dbb015003.set調定年度(調定年度);
        dbb015003.set賦課年度(賦課年度);
        dbb015003.set処理対象月(処理対象月);
        dbb015003.set普徴仮算定異動方法(普徴仮算定異動方法);
        dbb015003.set抽出開始日時(抽出開始日時);
        dbb015003.set抽出終了日時(抽出終了日時);
        dbb015003.set帳票グループ(帳票グループ);
        dbb015003.set出力帳票一覧List(出力帳票一覧List);
        dbb015003.set特徴_発行日(特徴_発行日);
        dbb015003.set仮算定額変更_発行日(仮算定額変更_発行日);
        dbb015003.set文書番号(文書番号);
        dbb015003.set納入_出力期(納入_出力期);
        dbb015003.set納入_出力方式(納入_出力方式);
        dbb015003.set納入_発行日(納入_発行日);
        dbb015003.set納入_対象者(納入_対象者);
        dbb015003.set納入_生活保護対象者(納入_生活保護対象者);
        dbb015003.set納入_ページごとに山分け(納入_ページごとに山分け);
        dbb015003.set特徴仮算定賦課処理日時(特徴仮算定賦課処理日時);
        dbb015003.set普徴仮算定賦課処理日時(普徴仮算定賦課処理日時);
        dbb015003.set一括発行起動フラグ(一括発行起動フラグ);
        dbb015003.set特徴捕捉対象者の依頼金額計算区分(特徴捕捉対象者の依頼金額計算区分);
        dbb015003.set算定期(算定期);
        dbb015003.setバッチ起動フラグ(バッチ起動フラグ);
        return dbb015003;
    }
}
