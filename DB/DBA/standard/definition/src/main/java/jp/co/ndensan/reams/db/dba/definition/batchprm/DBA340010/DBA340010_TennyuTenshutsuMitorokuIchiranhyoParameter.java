/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA340010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba340010.TennyuTensyutsuMiTorokuIchiranhyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 転入転出未登録一覧表のBatchParameterクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter extends BatchParameterBase {

    private static final String KEY_SHICHOSONCODE = "shichosoncode";
    private static final String KEY_TENSYUTSUSAKUSEIJIYUCODE = "tensyutsusakuseiJiyucode";
    private static final String KEY_TENNYUSAKUSEIJIYUCODE = "tennyusakuseijiyucode";
    private static final String KEY_KAISHINICHI = "kaishinichi";
    private static final String KEY_SYURYONICHI = "syuryonichi";
    private static final String KEY_CYOHYOSYUTSURYOKUJYUNID = "cyohyosyutsuryokujyunid";
    private static final long serialVersionUID = -1867218998977744243L;

    @BatchParameter(key = KEY_SHICHOSONCODE, name = "市町村コードList")
    private List<LasdecCode> shichosoncode;
    @BatchParameter(key = KEY_TENSYUTSUSAKUSEIJIYUCODE, name = "転出作成事由コードList")
    private List<RString> tensyutsusakuseiJiyucode;
    @BatchParameter(key = KEY_TENNYUSAKUSEIJIYUCODE, name = "転入作成事由コードList")
    private List<RString> tennyusakuseijiyucode;
    @BatchParameter(key = KEY_KAISHINICHI, name = "開始日")
    private FlexibleDate kaishinichi;
    @BatchParameter(key = KEY_SYURYONICHI, name = "終了日")
    private FlexibleDate syuryonichi;
    @BatchParameter(key = KEY_CYOHYOSYUTSURYOKUJYUNID, name = "帳票出力順ID")
    private Long cyohyosyutsuryokujyunid;

    /**
     * コンストラクタです。
     *
     */
    public DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shichosoncode 市町村コードList
     * @param tensyutsusakuseiJiyucode 転出作成事由コードList
     * @param tennyusakuseijiyucode 転入作成事由コードList
     * @param kaishinichi 開始日
     * @param syuryonichi 終了日
     * @param cyohyosyutsuryokujyunid 帳票出力順ID
     */
    public DBA340010_TennyuTenshutsuMitorokuIchiranhyoParameter(List<LasdecCode> shichosoncode, List<RString> tensyutsusakuseiJiyucode,
            List<RString> tennyusakuseijiyucode, FlexibleDate kaishinichi, FlexibleDate syuryonichi, Long cyohyosyutsuryokujyunid) {
        this.shichosoncode = shichosoncode;
        this.tensyutsusakuseiJiyucode = tensyutsusakuseiJiyucode;
        this.tennyusakuseijiyucode = tennyusakuseijiyucode;
        this.kaishinichi = kaishinichi;
        this.syuryonichi = syuryonichi;
        this.cyohyosyutsuryokujyunid = cyohyosyutsuryokujyunid;
    }

    /**
     * バーチのパラメータを作成します。
     *
     * @return TennyuTensyutsuMiTorokuIchiranhyoProcessParameter
     */
    public TennyuTensyutsuMiTorokuIchiranhyoProcessParameter toTennyuTensyutsuMiTorokuIchiranhyoProcessParameter() {
        return new TennyuTensyutsuMiTorokuIchiranhyoProcessParameter(shichosoncode, tensyutsusakuseiJiyucode, tennyusakuseijiyucode,
                kaishinichi, syuryonichi, cyohyosyutsuryokujyunid);
    }

}
