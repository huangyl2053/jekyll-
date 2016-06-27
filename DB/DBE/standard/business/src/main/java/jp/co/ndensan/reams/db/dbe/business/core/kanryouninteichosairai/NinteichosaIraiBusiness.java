/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.kanryouninteichosairai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosairai.ChosaKekkaNyuryokuMobileRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 完了処理・認定調査依頼のモバイル入力用データのBusinessです。
 *
 * @reamsid_L DBE-0300-010 dingyi
 */
public class NinteichosaIraiBusiness {

    private final ChosaKekkaNyuryokuMobileRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ChosaKekkaNyuryokuMobileRelateEntity
     */
    public NinteichosaIraiBusiness(ChosaKekkaNyuryokuMobileRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public Code get認定申請区分_申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
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
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaName();
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
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
    }

    /**
     * 調査委託先を返します。
     *
     * @return 調査委託先
     */
    public RString get調査委託先() {
        return entity.getChosaItakusaki();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 概況調査テキスト・イメージ区分を返します。
     *
     * @return 概況調査テキスト・イメージ区分
     */
    public RString get概況調査テキスト_イメージ区分() {
        return entity.getGaikyoChosaTextImageKubun();
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
     * 認定調査・サービス区分コードを返します。
     *
     * @return 認定調査・サービス区分コード
     */
    public Code get認定調査_サービス区分コード() {
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
     * （概況特記）申請書管理番号を返します。
     *
     * @return （概況特記）申請書管理番号
     */
    public ShinseishoKanriNo get概況特記_申請書管理番号() {
        return entity.getGaikyoTokkiShinseishoKanriNo();
    }

    /**
     * （概況特記）認定調査依頼履歴番号を返します。
     *
     * @return （概況特記）認定調査依頼履歴番号
     */
    public int get概況特記_認定調査依頼履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 概況特記テキスト・イメージ区分を返します。
     *
     * @return 概況特記テキスト・イメージ区分
     */
    public RString get概況特記テキスト_イメージ区分() {
        return entity.getGaikyoTokkiTextImageKubun();
    }

    /**
     * 住宅改修（改修箇所）を返します。
     *
     * @return 住宅改修（改修箇所）
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
     * 概況特記事項（主訴）を返します。
     *
     * @return 概況特記事項（主訴）
     */
    public RString get概況特記事項_主訴() {
        return entity.getShuso();
    }

    /**
     * 概況特記事項（家族状況）を返します。
     *
     * @return 概況特記事項（家族状況）
     */
    public RString get概況特記事項_家族状況() {
        return entity.getKazokuJokyo();
    }

    /**
     * 概況特記事項（居住環境）を返します。
     *
     * @return 概況特記事項（居住環境）
     */
    public RString get概況特記事項_居住環境() {
        return entity.getKyojuKankyo();
    }

    /**
     * 概況特記事項（機器・器械）を返します。
     *
     * @return 概況特記事項（機器・器械）
     */
    public RString get概況特記事項_機器器械() {
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
     * 特記事項テキスト・イメージ区分を返します。
     *
     * @return 特記事項テキスト・イメージ区分
     */
    public RString get特記事項テキスト_イメージ区分() {
        return entity.getTokkijikoTextImageKubun();
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
        return entity.getServiceJokyoRemban();
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
     * サービスの状況フラグ連番を返します。
     *
     * @return サービスの状況フラグ連番
     */
    public int getサービスの状況フラグ連番() {
        return entity.getServiceJokyoFlagRemban();
    }

    /**
     * サービスの状況フラグを返します。
     *
     * @return サービスの状況フラグ
     */
    public boolean isサービスの状況フラグ() {
        return entity.isServiceJokyoFlag();
    }

    /**
     * 記入項目連番を返します。
     *
     * @return 記入項目連番
     */
    public int get記入項目連番() {
        return entity.getKinyuRemban();
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
     * 施設利用連番を返します。
     *
     * @return 施設利用連番
     */
    public int get施設利用連番() {
        return entity.getShisetsuRiyoRemban();
    }

    /**
     * 施設利用フラグを返します。
     *
     * @return 施設利用フラグ
     */
    public boolean is施設利用フラグ() {
        return entity.isShisetsuRiyoFlag();
    }

    /**
     * 認定調査・認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査・認知症高齢者の日常生活自立度コード
     */
    public Code get認知症高齢者の日常生活自立度コード() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査・障害高齢者の日常生活自立度コード
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
        return entity.getResearchItemRemban();
    }

    /**
     * 調査項目を返します。
     *
     * @return 調査項目
     */
    public RString get調査項目() {
        return entity.getResearchItem();
    }

}
