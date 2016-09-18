/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書発行一覧リストEntityです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinOshiraseTsuchishoHakoEntity {

    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 要介護度;
    private RString 受給申請日;
    private RString 認定日;
    private RString 認定開始日;
    private RString 認定終了日;
    private RString 受給申請事由;
    private RString 申請区分_申請時;
    private RString 申請区分_法令;
    private RString 居宅支援事業者コード;
    private RString 居宅支援事業者名称;
    private RString 入所施設事業者コード;
    private RString 入所施設事業者名称;
    private int 連番;

}
