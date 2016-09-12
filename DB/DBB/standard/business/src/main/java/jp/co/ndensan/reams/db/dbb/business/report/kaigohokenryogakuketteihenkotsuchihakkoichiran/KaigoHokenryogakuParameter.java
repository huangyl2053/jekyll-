/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigohokenryogaku.KaigoHokenryogakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表KaigoHokenryogakuParameter
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenryogakuParameter {

    private RString 賦課年度;
    private RString 調定年度;
    private List<KaigoHokenryogakuEntity> 出力帳票entity;
    private RString 出力期;
}
