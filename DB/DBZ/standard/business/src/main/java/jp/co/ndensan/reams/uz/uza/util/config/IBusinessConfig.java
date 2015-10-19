/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.uz.uza.util.config;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

public interface IBusinessConfig {

    public RString get(Enum e);

    public RString get(Enum e, RDate rdate);

    public RString get(Enum e, RString rs);

    public RString get(Enum e, RDate rdate, RString rs);

    public RString get(Enum e, SubGyomuCode sgc);

    public RString get(Enum e, RDate rdate, SubGyomuCode sgc);

    public RString get(Enum e, SubGyomuCode sgc, RString rs);

    public RString get(Enum e, RDate rdate, SubGyomuCode sgc, RString rs);

    public BusinessConfigInfo getConfigInfo(Enum e, RDate rdate);

    public BusinessConfigInfo getConfigInfo(Enum e, RDate rdate, RString rs);

    public BusinessConfigInfo getConfigInfo(Enum e, SubGyomuCode sgc);

    public BusinessConfigInfo getConfigInfo(Enum e, RDate rdate, SubGyomuCode sgc);

    public BusinessConfigInfo getConfigInfo(Enum e, SubGyomuCode sgc, RString rs);

    public BusinessConfigInfo getConfigInfo(Enum e, RDate rdate, SubGyomuCode sgc, RString rs);

    public boolean update(RString rs, RString rs1, RString rs2, RString rs3, RDate rdate);

    public boolean reset(RString rs, RString rs1, RString rs2, RDate rdate);

    public RString _getSchemaName(SubGyomuCode sgc);
}
