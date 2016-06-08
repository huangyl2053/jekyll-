/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 転入転出未登録一覧表ボディのITEMです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoBodyItem {

    private RString データ内容;
    private RString 市町村コード;
    private RString 市町村名;
    private RString 住民状態;
    private RString 異動事由コード;
    private RString 異動事由;
    private RString 住所地特例;
    private RString 住所;
    private RString 識別コード;
    private RString カナ氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 登録異動日;
    private RString 消除異動日;
    private RString 転出予定異動日;
    private RString 転出予定住所前住所;
    private RString 作成事由コードMiddle;
    private RString 作成事由Middle;
    private RString 世帯コード;
    private RString 氏名;
    private RString 登録届出日;
    private RString 消除届出日;
}
