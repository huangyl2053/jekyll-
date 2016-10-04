/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護給付費再審査申立書作成の給付実績一覧と再審査申立一覧検索クラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateTourokuCollect implements Serializable {

    private RString 被保険者番号;
    private RString 被保険者名称;
    private RString 事業所番号;
    private RString 事業者名称;
    private RString 保険者番号;
    private RString 提供年月開始;
    private RString 提供年月終了;
    private RString 画面状態;
    private RString 市町村コード;
    private RString 一覧モード;
    private List<KyufuJissekiGaitoshaBusiness> 給付実績情報List;
    private List<SaishinsaMoshitateJohoBusiness> 再審査申立情報List;
}
