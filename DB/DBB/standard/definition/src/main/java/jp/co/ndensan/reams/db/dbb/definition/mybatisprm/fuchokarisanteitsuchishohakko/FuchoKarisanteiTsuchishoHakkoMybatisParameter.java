/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokarisanteitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行のmybatisパラメーターです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKarisanteiTsuchishoHakkoMybatisParameter implements IMyBatisParameter {

    private YMDHMS システム日時;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private List<BatchFuchoKariSanteiEntity> 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力方法;
    private RString 出力期の表示方法;
    private RString 出力期;
    private RString 対象者;
    private RString 生活保護対象者をまとめて先頭に出力;
    private RString ページごとに山分け;
    private boolean 一括発行起動フラグ;
}
