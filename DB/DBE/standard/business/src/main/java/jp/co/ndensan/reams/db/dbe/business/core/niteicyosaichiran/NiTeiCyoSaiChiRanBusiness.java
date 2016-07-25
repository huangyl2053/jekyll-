/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.niteicyosaichiran;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niteicyosaichiran.NiTeiCyoSaiChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査一覧Businessです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NiTeiCyoSaiChiRanBusiness implements Serializable {

    private final NiTeiCyoSaiChiRanRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 認定調査一覧に使用します。
     *
     * @param entity NiTeiCyoSaiChiRanRelateEntity
     */
    public NiTeiCyoSaiChiRanBusiness(NiTeiCyoSaiChiRanRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteiChosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 申請書管理番号 を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 被保険者番号 を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名 を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分_申請時コードを返します。
     *
     * @return 認定申請区分_申請時コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 保険者を返します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.getHokensya();
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return entity.getNinteichosaKanryoYMD();
    }

    /**
     * 概況特記テキスト・イメージ区分を返します。
     *
     * @return 概況特記テキスト・イメージ区分
     */
    public RString get概況特記テキストイメージ区分() {
        return entity.getGaikyoTokkiTextImageKubun();
    }

    /**
     * 認定調査依頼区分コードを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.getNinteichousaIraiKubunCode();
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return entity.getNinteichosaIraiKaisu();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 認定調査受領年月日を返します。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate get認定調査受領年月日() {
        return entity.getNinteichosaJuryoYMD();
    }

    /**
     * 認定調査区分コードを返します。
     *
     * @return 認定調査区分コード
     */
    public Code get認定調査区分コード() {
        return entity.getNinteiChosaKubunCode();
    }

    /**
     * 認定調査実施場所コードを返します。
     *
     * @return 認定調査実施場所コード
     */
    public Code get認定調査実施場所コード() {
        return entity.getChosaJisshiBashoCode();
    }

    /**
     * 認定調査実施場所名称を返します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return entity.getChosaJisshiBashoMeisho();
    }

    /**
     * サービス区分コードを返します。
     *
     * @return サービス区分コード
     */
    public Code getサービス区分コード() {
        return entity.getServiceKubunCode();
    }

    /**
     * 利用施設名を返します。
     *
     * @return 利用施設名
     */
    public RString get利用施設名() {
        return entity.getRiyoShisetsuShimei();
    }

    /**
     * 利用施設住所を返します。
     *
     * @return 利用施設住所
     */
    public RString get利用施設住所() {
        return entity.getRiyoShisetsuJusho();
    }

    /**
     * 利用施設電話番号を返します。
     *
     * @return 利用施設電話番号
     */
    public RString get利用施設電話番号() {
        return entity.getRiyoShisetsuTelNo();
    }

    /**
     * 利用施設郵便番号を返します。
     *
     * @return 利用施設郵便番号
     */
    public YubinNo get利用施設郵便番号() {
        return entity.getRiyoShisetsuYubinNo();
    }

    /**
     * 特記を返します。
     *
     * @return 特記
     */
    public RString get特記() {
        return entity.getTokki();
    }

    /**
     * 認定調査特記事項受付年月日を返します。
     *
     * @return 認定調査特記事項受付年月日
     */
    public FlexibleDate get認定調査特記事項受付年月日() {
        return entity.getTokkijikoUketsukeYMD();
    }

    /**
     * 認定調査特記事項受領年月日を返します。
     *
     * @return 認定調査特記事項受領年月日
     */
    public FlexibleDate get認定調査特記事項受領年月日() {
        return entity.getTokkijikoJuryoYMD();
    }

    /**
     * 住宅改修_改修箇所を返します。
     *
     * @return 住宅改修_改修箇所
     */
    public RString get住宅改修_改修箇所() {
        return entity.getJutakuKaishu();
    }

    /**
     * 市町村特別給付サービス種類名を返します。
     *
     * @return 市町村特別給付サービス種類名
     */
    public RString get市町村特別給付サービス種類名() {
        return entity.getTokubetsuKyufuService();
    }

    /**
     * 介護保険給付以外の在宅サービス種類名を返します。
     *
     * @return 介護保険給付以外の在宅サービス種類名
     */
    public RString get介護保険給付以外の在宅サービス種類名() {
        return entity.getZaitakuService();
    }

    /**
     * 概況特記事項_主訴を返します。
     *
     * @return 概況特記事項_主訴
     */
    public RString get概況特記事項_主訴() {
        return entity.getShuso();
    }

    /**
     * 概況特記事項_家族状況を返します。
     *
     * @return 概況特記事項_家族状況
     */
    public RString get概況特記事項_家族状況() {
        return entity.getKazokuJokyo();
    }

    /**
     * 概況特記事項_居住環境を返します。
     *
     * @return 概況特記事項_居住環境
     */
    public RString get概況特記事項_居住環境() {
        return entity.getKyojuKankyo();
    }

    /**
     * 器械を返します。
     *
     * @return 器械
     */
    public RString get器械() {
        return entity.getKikaiKiki();
    }

    /**
     * 認定調査特記事項番号を返します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return entity.getNinteichosaTokkijikoNo();
    }

    /**
     * 認定調査特記事項連番を返します。
     *
     * @return 認定調査特記事項連番
     */
    public int get認定調査特記事項連番() {
        return entity.getNinteichosaTokkijikoRemban();
    }

    /**
     * 原本マスク区分を返します。
     *
     * @return 原本マスク区分
     */
    public Code get原本マスク区分() {
        return entity.getGenponMaskKubun();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return entity.getTokkiJiko();
    }

    /**
     * サービスの状況連番を返します。
     *
     * @return サービスの状況連番
     */
    public int getサービスの状況連番() {
        return entity.getSabisuremban();
    }

    /**
     * サービスの状況を返します。
     *
     * @return サービスの状況
     */
    public int getサービスの状況() {
        return entity.getServiceJokyo();
    }

    /**
     * サービスの状況記入を返します。
     *
     * @return サービスの状況記入
     */
    public RString getサービスの状況記入() {
        return entity.getServiceJokyoKinyu();
    }

    /**
     * 施設利用フラグを返します。
     *
     * @return 施設利用フラグ
     */
    public boolean get施設利用フラグ() {
        return entity.isShisetsuRiyoFlag();
    }

    /**
     * 認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認知症高齢者の日常生活自立度コード
     */
    public Code get認知症高齢者の日常生活自立度コード() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 障害高齢者の日常生活自立度コードを返します。
     *
     * @return 障害高齢者の日常生活自立度コード
     */
    public Code get障害高齢者の日常生活自立度コード() {
        return entity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 調査項目連番を返します。
     *
     * @return 調査項目連番
     */
    public int get調査項目連番() {
        return entity.getCyusakomokuremban();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return entity.getResearchItem();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * サービスの状況フラグを返します。
     *
     * @return サービスの状況フラグ
     */
    public boolean getサービスの状況フラグ() {
        return entity.isServiceJokyoFlag();
    }

}
