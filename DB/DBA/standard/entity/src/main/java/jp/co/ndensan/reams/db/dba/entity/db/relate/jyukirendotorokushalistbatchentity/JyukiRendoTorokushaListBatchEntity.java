/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.jyukirendotorokushalistbatchentity;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住基連動登録者リストEntity。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukiRendoTorokushaListBatchEntity {

    private LasdecCode 市町村コード;
    private RString 市町村名;
    private RString 並び順_1;
    private RString 並び順_2;
    private RString 並び順_3;
    private RString 並び順_4;
    private RString 並び順_5;
    private RString 改頁_1;
    private RString 改頁_2;
    private RString 改頁_3;
    private RString 改頁_4;
    private RString 改頁_5;
    private List<JyukiRendoJouhouEntity> 住基連動情報;
    private RString 抽出期間F;
    private RString 抽出期間T;
}
