/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tennyutenshutsumitorokuichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転入転出未登録一覧表のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter implements IMyBatisParameter {

    private final List<LasdecCode> shichosoncode;
    private final List<RString> tensyutsusakuseiJiyucode;
    private final List<RString> tennyusakuseijiyucode;
    private final FlexibleDate kaishinichi;
    private final FlexibleDate syuryonichi;

    /**
     * コンストラクタです。
     *
     * @param shichosoncode 市町村コードList
     * @param tensyutsusakuseiJiyucode 転出作成事由コードList
     * @param tennyusakuseijiyucode 転入作成事由コードList
     * @param kaishinichi 開始日
     * @param syuryonichi 終了日
     */
    public TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter(List<LasdecCode> shichosoncode, List<RString> tensyutsusakuseiJiyucode,
            List<RString> tennyusakuseijiyucode, FlexibleDate kaishinichi, FlexibleDate syuryonichi) {
        this.shichosoncode = shichosoncode;
        this.tensyutsusakuseiJiyucode = tensyutsusakuseiJiyucode;
        this.tennyusakuseijiyucode = tennyusakuseijiyucode;
        this.kaishinichi = kaishinichi;
        this.syuryonichi = syuryonichi;
    }

}
