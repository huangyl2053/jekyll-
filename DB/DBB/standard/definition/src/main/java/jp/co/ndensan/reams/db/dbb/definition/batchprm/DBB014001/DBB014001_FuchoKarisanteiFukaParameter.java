/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.DBB014003_FuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchTyouhyou;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 普徴仮算定賦課のバッチパラメータクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB014001_FuchoKarisanteiFukaParameter extends BatchParameterBase {

    private static final String HAKKOYMD = "発行日";
    private static final String SYUTSURYOKUHOUHOU = "出力方法";
    private static final String NOTSUSHUTURYOKUKIHOUHOU = "出力期の表示方法";
    private static final String NOTSUSHUTURYOKUKI = "出力期";
    private static final String NOTSUTAISHOSHA = "対象者";
    private static final String NOTSUSEIKATSUHOGO = "生活保護対象者をまとめて先頭に出力";
    private static final String NOTSUYAMAWAKE = "ページごとに山分け";
    private static final String FLAG = "一括発行起動フラグ";

    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    @BatchParameter(key = "調定年度", name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = "賦課年度", name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = "出力帳票一覧", name = "出力帳票一覧")
    private List<HonsanteifukaBatchTyouhyou> 出力帳票一覧;
    @BatchParameter(key = HAKKOYMD, name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = SYUTSURYOKUHOUHOU, name = "出力方法")
    private RString 出力方法;
    @BatchParameter(key = NOTSUSHUTURYOKUKIHOUHOU, name = "出力期の表示方法")
    private RString 出力期の表示方法;
    @BatchParameter(key = NOTSUSHUTURYOKUKI, name = "出力期")
    private RString 出力期;
    @BatchParameter(key = NOTSUTAISHOSHA, name = "対象者")
    private RString 対象者;
    @BatchParameter(key = NOTSUSEIKATSUHOGO, name = "生活保護対象者をまとめて先頭に出力")
    private RString 生活保護対象者をまとめて先頭に出力;
    @BatchParameter(key = NOTSUYAMAWAKE, name = "ページごとに山分け")
    private RString ページごとに山分け;
    @BatchParameter(key = FLAG, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;

    /**
     * 普徴仮算定通知書一括発行のバッチパラメーターを生成します。
     *
     * @return 普徴仮算定通知書一括発行のバッチパラメーター
     */
    public DBB014003_FuchoKarisanteiTsuchishoHakkoParameter toDBB014003_FuchoKarisanteiTsuchishoHakkoParameter() {
        DBB014003_FuchoKarisanteiTsuchishoHakkoParameter param = new DBB014003_FuchoKarisanteiTsuchishoHakkoParameter();
        param.set賦課年度(賦課年度);
        param.set調定年度(調定年度);
        param.set発行日(発行日);
        param.set生活保護対象者をまとめて先頭に出力(生活保護対象者をまとめて先頭に出力);
        param.set対象者(対象者);
        param.set出力期の表示方法(出力期の表示方法);
        param.set出力期(出力期);
        param.set出力方法(出力方法);
        param.set一括発行起動フラグ(false);
        param.setページごとに山分け(ページごとに山分け);
        List<BatchFuchoKariSanteiEntity> 出力帳票一覧List = new ArrayList<>();
        for (HonsanteifukaBatchTyouhyou entity : 出力帳票一覧) {
            BatchFuchoKariSanteiEntity santeiEntity = new BatchFuchoKariSanteiEntity();
            santeiEntity.set出力順ID(Integer.valueOf(entity.get出力順ID().toString()));
            santeiEntity.set帳票ID(entity.get帳票ID());
            santeiEntity.set帳票分類ID(entity.get帳票分類ID());
            if (納入通知書_帳票分類ID.equals(entity.get帳票分類ID())) {
                出力帳票一覧List.set(INT_0, santeiEntity);
            } else {
                出力帳票一覧List.set(INT_1, santeiEntity);
            }
        }
        param.set出力帳票一覧List(出力帳票一覧List);
        return param;
    }
}
