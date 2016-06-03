package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taisyosyajidowaritsuke;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
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
public final class TaisyosyaJidoWaritsukeMybatisParameter implements IMyBatisParameter {

    private final RString shinsakaiKaisaiNo;
    private final RString shinseishoKanriNo;
    private final ChosaItakusakiCode ninteiChosaItakusakiCode;
    private final ChosainCode ninteiChosainCode;
    private final RString shujiiIryokikanCode;
    private final RString shujiiCode;
    private final JigyoshaNo nyushoShisetsuCode;
    private final boolean isKikanMade;

    /**
     * コンストラクタです。
     *
     * @param 審査会開催番号 審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 入所施設コード 入所施設コード
     * @param is機関まで is機関まで
     */
    public TaisyosyaJidoWaritsukeMybatisParameter(RString 審査会開催番号,
            RString 申請書管理番号,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード,
            RString 主治医医療機関コード,
            RString 主治医コード,
            JigyoshaNo 入所施設コード,
            boolean is機関まで) {
        this.shinsakaiKaisaiNo = 審査会開催番号;
        this.shinseishoKanriNo = 申請書管理番号;
        this.ninteiChosaItakusakiCode = 認定調査委託先コード;
        this.ninteiChosainCode = 認定調査員コード;
        this.shujiiIryokikanCode = 主治医医療機関コード;
        this.shujiiCode = 主治医コード;
        this.nyushoShisetsuCode = 入所施設コード;
        this.isKikanMade = is機関まで;
    }
}
