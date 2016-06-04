package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBB-1770-070 yebangqiang
 */
public interface IKaigoChohyoSeigyoKyotsuDiv extends ICommonChildDivBaseProperties {

    /**
     * 介護帳票制御共通情報の初期化
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     */
    void initialize(SubGyomuCode subGyomuCode, ReportId reportId);

    /**
     * 介護帳票制御共通情報の保存
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     */
    void save(SubGyomuCode subGyomuCode, ReportId reportId);
}
