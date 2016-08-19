package jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshasho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 総合事業対象者情報のエンティティクラスです。
 *
 * @reamsid_L DBU-0420-020 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class SogoJigyoTaishoshaRelateEntity implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private LasdecCode 市町村コード_受給;
    private RString 識別コード_受給;
    private LasdecCode 市町村コード_ビュー;
    private RString 識別コード_ビュー;
    private RDateTime 更新日時_受給;
    private RDateTime 挿入日時_受給;
    private RDateTime 更新日時_総合;
    private RDateTime 挿入日時_総合;
    private FlexibleDate チェックリスト実施日;
    private FlexibleDate 認定年月日;
    private RString 対象区分;
    private RString 適用開始日;
    private RString 適用終了日;
}
