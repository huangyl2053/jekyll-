/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba340010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 転入転出未登録一覧表のProcessParameter。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TennyuTensyutsuMiTorokuIchiranhyoProcessParameter implements IBatchProcessParameter {

    private List<LasdecCode> shichosoncode;
    private List<RString> tensyutsusakuseiJiyucode;
    private List<RString> tennyusakuseijiyucode;
    private FlexibleDate kaishinichi;
    private FlexibleDate syuryonichi;
    private Long cyohyosyutsuryokujyun;

    /**
     * コンストラクタです。
     *
     * @param shichosoncode 市町村コードList
     * @param tensyutsusakuseiJiyucode 転出作成事由コードList
     * @param tennyusakuseijiyucode 転入作成事由コードList
     * @param kaishinichi 開始日
     * @param syuryonichi 終了日
     * @param cyohyosyutsuryokujyun 帳票出力順ID
     */
    public TennyuTensyutsuMiTorokuIchiranhyoProcessParameter(List<LasdecCode> shichosoncode, List<RString> tensyutsusakuseiJiyucode,
            List<RString> tennyusakuseijiyucode, FlexibleDate kaishinichi, FlexibleDate syuryonichi, Long cyohyosyutsuryokujyun) {
        this.shichosoncode = shichosoncode;
        this.tensyutsusakuseiJiyucode = tensyutsusakuseiJiyucode;
        this.tennyusakuseijiyucode = tennyusakuseijiyucode;
        this.kaishinichi = kaishinichi;
        this.syuryonichi = syuryonichi;
        this.cyohyosyutsuryokujyun = cyohyosyutsuryokujyun;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return TennyuTensyutsuMiTorokuIchiranhyoMybatisParameter
     */
    public TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter toTennyuTensyutsuMiTorokuIchiranhyoMybatisParameter() {
        return new TennyuTenshutsuMiTorokuIchiranhyoMybatisParameter(shichosoncode, tensyutsusakuseiJiyucode, tennyusakuseijiyucode,
                kaishinichi, syuryonichi);
    }

}
