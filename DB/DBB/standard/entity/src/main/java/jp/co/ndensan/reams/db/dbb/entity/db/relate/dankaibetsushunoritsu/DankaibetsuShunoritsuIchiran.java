/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dankaibetsushunoritsu;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBB300003_保険料段階別収納率一覧表のパラメータクラスです。
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DankaibetsuShunoritsuIchiran {

    private RString 帳票タイトル;
    private RString hdn年度;
    private RString 年度;
    private RString 被保険者番号;
    private RString 被保険者名;
    private int 期;
    private RString 保険料段階;
    private int 調定額_件数;
    private Decimal 調定額;
    private int 収入額_件数;
    private Decimal 収入額;
    private Decimal 未納額;
    private int 還付額_件数;
    private Decimal 還付額;
    private int 充当額負_件数;
    private Decimal 充当額負;
    private int 充当額_件数;
    private Decimal 充当額;
    private int 不納欠損額_件数;
    private Decimal 不納欠損額;
    private RString 収納率;
    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 科目コード;
}
