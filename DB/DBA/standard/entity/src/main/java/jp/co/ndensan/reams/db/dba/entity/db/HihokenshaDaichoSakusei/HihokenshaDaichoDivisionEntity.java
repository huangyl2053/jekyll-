/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoDivisionEntity {

    private List<String> 資格異動No;
    private List<FlexibleDate> 取得日;
    private List<RString> 取得事由コード;
    private List<RString> 取得事由名称;
    private List<FlexibleDate> 号取得日;
    private List<FlexibleDate> 喪失日;
    private List<RString> 喪失事由コード;
    private List<RString> 喪失事由名称;
    private List<RString> 資格区分;
    private List<FlexibleDate> 変更日;
    private List<RString> 変更事由コード;
    private List<RString> 変更事由名称;
    private List<FlexibleDate> 住特適用日;
    private List<FlexibleDate> 住特解除日;
    private List<LasdecCode> 措置保険者;
    private List<LasdecCode> 旧保険者;

}
