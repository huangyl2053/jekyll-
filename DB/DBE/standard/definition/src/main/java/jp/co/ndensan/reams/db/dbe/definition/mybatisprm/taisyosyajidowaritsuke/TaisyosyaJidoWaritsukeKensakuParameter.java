package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 対象者自動割付のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-1350-040 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaisyosyaJidoWaritsukeKensakuParameter implements IMyBatisParameter {

    private final List<RString> shinsakaiKaisaiNoList;
    private final boolean isIchijiHanteiGo;

    /**
     * コンストラクタです。
     *
     * @param 審査会開催番号List 審査会開催番号List
     * @param is一次判定後 is一次判定後
     */
    public TaisyosyaJidoWaritsukeKensakuParameter(List<RString> 審査会開催番号List,
            boolean is一次判定後) {
        this.shinsakaiKaisaiNoList = 審査会開催番号List;
        this.isIchijiHanteiGo = is一次判定後;
    }
}
