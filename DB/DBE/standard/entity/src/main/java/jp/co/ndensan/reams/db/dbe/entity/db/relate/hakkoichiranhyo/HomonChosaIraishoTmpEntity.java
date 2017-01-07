/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import java.io.Serializable;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 訪問調査依頼書発行のRelateEntityクラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HomonChosaIraishoTmpEntity implements IDbAccessable, Serializable {

    @PrimaryKey
    private RString 申請書管理番号;
    @PrimaryKey
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 被保険者氏名;
    private RString 住所;
    private RString 生年月日;
    private RString 性別;
    private RString 郵便番号;
    private RString 電話番号;
    private RString 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 証記載保険者番号;
    private RString 年齢;
    private RString 訪問調査先住所;
    private RString 訪問調査先電話番号;
    private RString 訪問調査先名称;
    private RString 訪問調査先郵便番号;
    private RString 前回認定年月日;
    private RString 前回要介護状態区分コード;
    private RString 代表者名;
    private RString 調査委託先住所;
    private RString 事業者名称;
    private RString 調査委託先住所_郵便番号;
    private RString 事業者番号;
    private RString 調査員氏名;
    private FlexibleDate 認定調査依頼年月日;
    private Integer 最大依頼履歴番号;
    private RString 認定調査期限年月日;
    private RString 認定調査員コード;
    private RString 認定調査委託先コード;
    private RString 前回認知症高齢者自立度;
    private RString 前回障害高齢者自立度;
    private RString 要介護認定一次判定結果コード;
    private RString 二次判定要介護状態区分コード;
    private RString 二次判定年月日;
    private RString 前回連番;
    private RString 前回連番に対する調査項目;
    private RString 連絡先郵便番号;
    private RString 連絡先電話番号;
    private RString 連絡先携帯番号;
    private RString 連絡先氏名;
    private RString 連絡先続柄;
    private RString 連絡先住所;
    private RString 厚労省IF識別コード;
    private RString 今回一次判定結果コード;
    private RString 介護認定審査会開催年月日;
    private RString 合議体番号;
    private RString 今回障害高齢者自立度;
    private RString 今回認知症高齢者自立度;
    private RString 今回連番;
    private RString 今回連番に対する調査項目;
    private RString 直近区分;
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaIraiRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private JigyoshaNo ninteichosaItakusakiCode;
    private RString ninteiChosainCode;
    private Code ninteichosaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaKigenYMD;
    private FlexibleDate iraishoShutsuryokuYMD;
    private FlexibleDate chosahyoTouShutsuryokuYMD;
    private boolean mobileDataShutsuryokuZumiFlag;
    private boolean jizenChosaFlag;
    private FlexibleDate ninteichosaTokusokuYMD;
    private RString ninteichosaTokusokuHoho;
    private int ninteichosaTokusokuKaisu;
    private RString ninteichosaTokusokuMemo;
    private boolean logicalDeletedFlag;

    public HomonChosaIraishoTmpEntity() {

    }

    public HomonChosaIraishoTmpEntity(HomonChosaIraishoRelateEntity entity) {
        this.申請書管理番号 = entity.get申請書管理番号();
        this.被保険者番号 = entity.get被保険者番号();
        this.被保険者氏名カナ = entity.get被保険者氏名カナ();
        this.被保険者氏名 = entity.get被保険者氏名();
        this.住所 = entity.get住所();
        this.生年月日 = entity.get生年月日();
        this.性別 = entity.get性別();
        this.郵便番号 = entity.get郵便番号();
        this.電話番号 = entity.get電話番号();
        this.認定申請年月日 = entity.get認定申請年月日();
        this.認定申請区分_申請時_コード = entity.get認定申請区分_申請時_コード();
        this.証記載保険者番号 = entity.get証記載保険者番号();
        this.年齢 = entity.get年齢();
        this.訪問調査先住所 = entity.get訪問調査先住所();
        this.訪問調査先電話番号 = entity.get訪問調査先電話番号();
        this.訪問調査先名称 = entity.get訪問調査先名称();
        this.訪問調査先郵便番号 = entity.get訪問調査先郵便番号();
        this.前回認定年月日 = entity.get前回認定年月日();
        this.前回要介護状態区分コード = entity.get前回要介護状態区分コード();
        this.代表者名 = entity.get代表者名();
        this.調査委託先住所 = entity.get調査委託先住所();
        this.事業者名称 = entity.get事業者名称();
        this.調査委託先住所_郵便番号 = entity.get調査委託先住所_郵便番号();
        this.事業者番号 = entity.get事業者番号();
        this.調査員氏名 = entity.get調査員氏名();
        this.認定調査依頼年月日 = entity.get認定調査依頼年月日();
        this.最大依頼履歴番号 = entity.get最大依頼履歴番号();
        this.認定調査期限年月日 = entity.get認定調査期限年月日();
        this.認定調査員コード = entity.get認定調査員コード();
        this.認定調査委託先コード = entity.get認定調査委託先コード();
        this.前回認知症高齢者自立度 = entity.get前回認知症高齢者自立度();
        this.前回障害高齢者自立度 = entity.get前回障害高齢者自立度();
        this.要介護認定一次判定結果コード = entity.get要介護認定一次判定結果コード();
        this.二次判定要介護状態区分コード = entity.get二次判定要介護状態区分コード();
        this.二次判定年月日 = entity.get二次判定年月日();
        this.前回連番 = entity.get前回連番();
        this.前回連番に対する調査項目 = entity.get前回連番に対する調査項目();
        this.連絡先郵便番号 = entity.get連絡先郵便番号();
        this.連絡先電話番号 = entity.get連絡先電話番号();
        this.連絡先携帯番号 = entity.get連絡先携帯番号();
        this.連絡先氏名 = entity.get連絡先氏名();
        this.連絡先続柄 = entity.get連絡先続柄();
        this.連絡先住所 = entity.get連絡先住所();
        this.厚労省IF識別コード = entity.get厚労省IF識別コード();
        this.今回一次判定結果コード = entity.get今回一次判定結果コード();
        this.介護認定審査会開催年月日 = entity.get介護認定審査会開催年月日();
        this.合議体番号 = entity.get合議体番号();
        this.今回障害高齢者自立度 = entity.get今回障害高齢者自立度();
        this.今回認知症高齢者自立度 = entity.get今回認知症高齢者自立度();
        this.今回連番 = entity.get今回連番();
        this.今回連番に対する調査項目 = entity.get今回連番に対する調査項目();
        this.直近区分 = entity.get直近区分();
        this.insertDantaiCd = entity.getDbt5201Entity().getInsertDantaiCd();
//        this.insertTimestamp = entity.getDbt5201Entity().getInsertTimestamp();
//        this.insertReamsLoginId = entity.getDbt5201Entity().getinsertReamsLoginId();
//        this.insertContextId = entity.getDbt5201Entity().getinsertContextId();
        this.isDeleted = entity.getDbt5201Entity().getIsDeleted();
//this.updateCount = entity.getDbt5201Entity().getupdateCount
//this.lastUpdateTimestamp = entity.getDbt5201Entity().getlastUpdateTimestamp();
//        this.lastUpdateReamsLoginId = entity.getDbt5201Entity().getlastUpdateReamsLoginId();
        this.shinseishoKanriNo = entity.getDbt5201Entity().getShinseishoKanriNo();
        this.ninteichosaIraiRirekiNo = entity.getDbt5201Entity().getNinteichosaIraiRirekiNo();
        this.koroshoIfShikibetsuCode = entity.getDbt5201Entity().getKoroshoIfShikibetsuCode();
        this.ninteichosaItakusakiCode = entity.getDbt5201Entity().getNinteichosaItakusakiCode();
        this.ninteiChosainCode = entity.getDbt5201Entity().getNinteiChosainCode();
        this.ninteichosaIraiKubunCode = entity.getDbt5201Entity().getNinteichosaIraiKubunCode();
        this.ninteichosaIraiKaisu = entity.getDbt5201Entity().getNinteichosaIraiKaisu();
        this.ninteichosaIraiYMD = entity.getDbt5201Entity().getNinteichosaIraiYMD();
        this.ninteichosaKigenYMD = entity.getDbt5201Entity().getNinteichosaKigenYMD();
        this.iraishoShutsuryokuYMD = entity.getDbt5201Entity().getIraishoShutsuryokuYMD();
        this.chosahyoTouShutsuryokuYMD = entity.getDbt5201Entity().getChosahyoTouShutsuryokuYMD();
        this.mobileDataShutsuryokuZumiFlag = entity.getDbt5201Entity().getMobileDataShutsuryokuZumiFlag();
        this.jizenChosaFlag = entity.getDbt5201Entity().getJizenChosaFlag();
        this.ninteichosaTokusokuYMD = entity.getDbt5201Entity().getNinteichosaTokusokuYMD();
        this.ninteichosaTokusokuHoho = entity.getDbt5201Entity().getNinteichosaTokusokuHoho();
        this.ninteichosaTokusokuKaisu = entity.getDbt5201Entity().getNinteichosaTokusokuKaisu();
        this.ninteichosaTokusokuMemo = entity.getDbt5201Entity().getNinteichosaTokusokuMemo();
        this.logicalDeletedFlag = entity.getDbt5201Entity().getLogicalDeletedFlag();

    }
}
