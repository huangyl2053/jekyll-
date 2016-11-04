/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名シール作成 処理結果リスト一時TBLEntity。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IChiJiTBLEntity {

    private RString エラー区分;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private RString キー1;
    private RString キー2;
    private RString キー3;
    private RString キー4;
    private RString キー5;
    private RString 備考;
}
