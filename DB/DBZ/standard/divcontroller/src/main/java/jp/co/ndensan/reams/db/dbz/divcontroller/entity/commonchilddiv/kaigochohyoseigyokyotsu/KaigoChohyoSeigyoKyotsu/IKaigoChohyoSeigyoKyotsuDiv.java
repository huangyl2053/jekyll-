package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBB-1770-070 yebangqiang
 */
public interface IKaigoChohyoSeigyoKyotsuDiv extends ICommonChildDivBaseProperties {

    void initialize(SubGyomuCode subGyomuCode, ReportId reportId);

    void save(SubGyomuCode subGyomuCode, ReportId reportId);
}
