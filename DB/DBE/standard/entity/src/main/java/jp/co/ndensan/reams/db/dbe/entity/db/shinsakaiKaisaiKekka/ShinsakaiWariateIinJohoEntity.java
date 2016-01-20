/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催結果登録の審査会委員一覧検索Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiWariateIinJohoEntity {

    private RString 介護認定審査会委員コード;
    private AtenaMeisho 介護認定審査会委員氏名;
    private RString 性別;
    private Code 介護認定審査員資格コード;
    private Code 合議体長区分コード;
    private Code 介護認定審査会議長区分コード;
    private boolean 委員出席;
    private boolean 委員遅刻有無;
    private RString 委員出席時間;
    private boolean 委員早退有無;
    private RString 委員退席時間;

}
