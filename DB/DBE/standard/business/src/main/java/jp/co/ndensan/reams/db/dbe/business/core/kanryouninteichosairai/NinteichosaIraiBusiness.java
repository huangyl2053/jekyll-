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

    /**
     * 調査項目連番１を返します。
     *
     * @return 調査項目連番１
     */
    public int get項目連番1() {
        return entity.getRemban1();
    }

    /**
     * 調査項目連番２を返します。
     *
     * @return 調査項目連番２
     */
    public int get項目連番2() {
        return entity.getRemban2();
    }

    /**
     * 調査項目連番３を返します。
     *
     * @return 調査項目連番３
     */
    public int get項目連番3() {
        return entity.getRemban3();
    }

    /**
     * 調査項目連番４を返します。
     *
     * @return 調査項目連番４
     */
    public int get項目連番4() {
        return entity.getRemban4();
    }

    /**
     * 調査項目連番５を返します。
     *
     * @return 調査項目連番５
     */
    public int get項目連番5() {
        return entity.getRemban5();
    }

    /**
     * 調査項目連番６を返します。
     *
     * @return 調査項目連番６
     */
    public int get項目連番6() {
        return entity.getRemban6();
    }

    /**
     * 調査項目連番７を返します。
     *
     * @return 調査項目連番７
     */
    public int get項目連番7() {
        return entity.getRemban7();
    }

    /**
     * 調査項目連番８を返します。
     *
     * @return 調査項目連番８
     */
    public int get項目連番8() {
        return entity.getRemban8();
    }

    /**
     * 調査項目連番９を返します。
     *
     * @return 調査項目連番９
     */
    public int get項目連番9() {
        return entity.getRemban9();
    }

    /**
     * 調査項目連番１０を返します。
     *
     * @return 調査項目連番１０
     */
    public int get項目連番10() {
        return entity.getRemban10();
    }

    /**
     * 調査項目連番１１を返します。
     *
     * @return 調査項目連番１１
     */
    public int get項目連番11() {
        return entity.getRemban11();
    }

    /**
     * 調査項目連番１２を返します。
     *
     * @return 調査項目連番１２
     */
    public int get項目連番12() {
        return entity.getRemban12();
    }

    /**
     * 調査項目連番１３を返します。
     *
     * @return 調査項目連番１３
     */
    public int get項目連番13() {
        return entity.getRemban13();
    }

    /**
     * 調査項目連番１４を返します。
     *
     * @return 調査項目連番１４
     */
    public int get項目連番14() {
        return entity.getRemban14();
    }

    /**
     * 調査項目連番１５を返します。
     *
     * @return 調査項目連番１５
     */
    public int get項目連番15() {
        return entity.getRemban15();
    }

    /**
     * 調査項目連番１６を返します。
     *
     * @return 調査項目連番１６
     */
    public int get項目連番16() {
        return entity.getRemban16();
    }

    /**
     * 調査項目連番１７を返します。
     *
     * @return 調査項目連番１７
     */
    public int get項目連番17() {
        return entity.getRemban17();
    }

    /**
     * 調査項目連番１８を返します。
     *
     * @return 調査項目連番１８
     */
    public int get項目連番18() {
        return entity.getRemban18();
    }

    /**
     * 調査項目連番１９を返します。
     *
     * @return 調査項目連番１９
     */
    public int get項目連番19() {
        return entity.getRemban19();
    }

    /**
     * 調査項目連番２０を返します。
     *
     * @return 調査項目連番２０
     */
    public int get項目連番20() {
        return entity.getRemban20();
    }

    /**
     * 調査項目連番２１を返します。
     *
     * @return 調査項目連番２１
     */
    public int get項目連番21() {
        return entity.getRemban21();
    }

    /**
     * 調査項目連番２２を返します。
     *
     * @return 調査項目連番２２
     */
    public int get項目連番22() {
        return entity.getRemban22();
    }

    /**
     * 調査項目連番２３を返します。
     *
     * @return 調査項目連番２３
     */
    public int get項目連番23() {
        return entity.getRemban23();
    }

    /**
     * 調査項目連番２４を返します。
     *
     * @return 調査項目連番２４
     */
    public int get項目連番24() {
        return entity.getRemban24();
    }

    /**
     * 調査項目連番２５を返します。
     *
     * @return 調査項目連番２５
     */
    public int get項目連番25() {
        return entity.getRemban25();
    }

    /**
     * 調査項目連番２６を返します。
     *
     * @return 調査項目連番２６
     */
    public int get項目連番26() {
        return entity.getRemban26();
    }

    /**
     * 調査項目連番２７を返します。
     *
     * @return 調査項目連番２７
     */
    public int get項目連番27() {
        return entity.getRemban27();
    }

    /**
     * 調査項目連番２８を返します。
     *
     * @return 調査項目連番２８
     */
    public int get項目連番28() {
        return entity.getRemban28();
    }

    /**
     * 調査項目連番２９を返します。
     *
     * @return 調査項目連番２９
     */
    public int get項目連番29() {
        return entity.getRemban29();
    }

    /**
     * 調査項目連番３０を返します。
     *
     * @return 調査項目連番３０
     */
    public int get項目連番30() {
        return entity.getRemban30();
    }

    /**
     * 調査項目連番３１を返します。
     *
     * @return 調査項目連番３１
     */
    public int get項目連番31() {
        return entity.getRemban31();
    }

    /**
     * 調査項目連番３２を返します。
     *
     * @return 調査項目連番３２
     */
    public int get項目連番32() {
        return entity.getRemban32();
    }

    /**
     * 調査項目連番３３を返します。
     *
     * @return 調査項目連番３３
     */
    public int get項目連番33() {
        return entity.getRemban33();
    }

    /**
     * 調査項目連番３４を返します。
     *
     * @return 調査項目連番３４
     */
    public int get項目連番34() {
        return entity.getRemban34();
    }

    /**
     * 調査項目連番３５を返します。
     *
     * @return 調査項目連番３５
     */
    public int get項目連番35() {
        return entity.getRemban35();
    }

    /**
     * 調査項目連番３６を返します。
     *
     * @return 調査項目連番３６
     */
    public int get項目連番36() {
        return entity.getRemban36();
    }

    /**
     * 調査項目連番３７を返します。
     *
     * @return 調査項目連番３７
     */
    public int get項目連番37() {
        return entity.getRemban37();
    }

    /**
     * 調査項目連番３８を返します。
     *
     * @return 調査項目連番３８
     */
    public int get項目連番38() {
        return entity.getRemban38();
    }

    /**
     * 調査項目連番３９を返します。
     *
     * @return 調査項目連番３９
     */
    public int get項目連番39() {
        return entity.getRemban39();
    }

    /**
     * 調査項目連番４０を返します。
     *
     * @return 調査項目連番４０
     */
    public int get項目連番40() {
        return entity.getRemban40();
    }

    /**
     * 調査項目連番４１を返します。
     *
     * @return 調査項目連番４１
     */
    public int get項目連番41() {
        return entity.getRemban41();
    }

    /**
     * 調査項目連番４２を返します。
     *
     * @return 調査項目連番４２
     */
    public int get項目連番42() {
        return entity.getRemban42();
    }

    /**
     * 調査項目連番４３を返します。
     *
     * @return 調査項目連番４３
     */
    public int get項目連番43() {
        return entity.getRemban43();
    }

    /**
     * 調査項目連番４４を返します。
     *
     * @return 調査項目連番４４
     */
    public int get項目連番44() {
        return entity.getRemban44();
    }

    /**
     * 調査項目連番４５を返します。
     *
     * @return 調査項目連番４５
     */
    public int get項目連番45() {
        return entity.getRemban45();
    }

    /**
     * 調査項目連番４６を返します。
     *
     * @return 調査項目連番４６
     */
    public int get項目連番46() {
        return entity.getRemban46();
    }

    /**
     * 調査項目連番４７を返します。
     *
     * @return 調査項目連番４７
     */
    public int get項目連番47() {
        return entity.getRemban47();
    }

    /**
     * 調査項目連番４８を返します。
     *
     * @return 調査項目連番４８
     */
    public int get項目連番48() {
        return entity.getRemban48();
    }

    /**
     * 調査項目連番４９を返します。
     *
     * @return 調査項目連番４９
     */
    public int get項目連番49() {
        return entity.getRemban49();
    }

    /**
     * 調査項目連番５０を返します。
     *
     * @return 調査項目連番５０
     */
    public int get項目連番50() {
        return entity.getRemban50();
    }

    /**
     * 調査項目連番５１を返します。
     *
     * @return 調査項目連番５１
     */
    public int get項目連番51() {
        return entity.getRemban51();
    }

    /**
     * 調査項目連番５２を返します。
     *
     * @return 調査項目連番５２
     */
    public int get項目連番52() {
        return entity.getRemban52();
    }

    /**
     * 調査項目連番５３を返します。
     *
     * @return 調査項目連番５３
     */
    public int get項目連番53() {
        return entity.getRemban53();
    }

    /**
     * 調査項目連番５４を返します。
     *
     * @return 調査項目連番５４
     */
    public int get項目連番54() {
        return entity.getRemban54();
    }

    /**
     * 調査項目連番５５を返します。
     *
     * @return 調査項目連番５５
     */
    public int get項目連番55() {
        return entity.getRemban55();
    }

    /**
     * 調査項目連番５６を返します。
     *
     * @return 調査項目連番５６
     */
    public int get項目連番56() {
        return entity.getRemban56();
    }

    /**
     * 調査項目連番５７を返します。
     *
     * @return 調査項目連番５７
     */
    public int get項目連番57() {
        return entity.getRemban57();
    }

    /**
     * 調査項目連番５８を返します。
     *
     * @return 調査項目連番５８
     */
    public int get項目連番58() {
        return entity.getRemban58();
    }

    /**
     * 調査項目連番５９を返します。
     *
     * @return 調査項目連番５９
     */
    public int get項目連番59() {
        return entity.getRemban59();
    }

    /**
     * 調査項目連番６０を返します。
     *
     * @return 調査項目連番６０
     */
    public int get項目連番60() {
        return entity.getRemban60();
    }

    /**
     * 調査項目連番６１を返します。
     *
     * @return 調査項目連番６１
     */
    public int get項目連番61() {
        return entity.getRemban61();
    }

    /**
     * 調査項目連番６２を返します。
     *
     * @return 調査項目連番６２
     */
    public int get項目連番62() {
        return entity.getRemban62();
    }

    /**
     * 調査項目連番６３を返します。
     *
     * @return 調査項目連番６３
     */
    public int get項目連番63() {
        return entity.getRemban63();
    }

    /**
     * 調査項目連番６４を返します。
     *
     * @return 調査項目連番６４
     */
    public int get項目連番64() {
        return entity.getRemban64();
    }

    /**
     * 調査項目連番６５を返します。
     *
     * @return 調査項目連番６５
     */
    public int get項目連番65() {
        return entity.getRemban65();
    }

    /**
     * 調査項目連番６６を返します。
     *
     * @return 調査項目連番６６
     */
    public int get項目連番66() {
        return entity.getRemban66();
    }

    /**
     * 調査項目連番６７を返します。
     *
     * @return 調査項目連番６７
     */
    public int get項目連番67() {
        return entity.getRemban67();
    }

    /**
     * 調査項目連番６８を返します。
     *
     * @return 調査項目連番６８
     */
    public int get項目連番68() {
        return entity.getRemban68();
    }

    /**
     * 調査項目連番６９を返します。
     *
     * @return 調査項目連番６９
     */
    public int get項目連番69() {
        return entity.getRemban69();
    }

    /**
     * 調査項目連番７０を返します。
     *
     * @return 調査項目連番７０
     */
    public int get項目連番70() {
        return entity.getRemban70();
    }

    /**
     * 調査項目連番７１を返します。
     *
     * @return 調査項目連番７１
     */
    public int get項目連番71() {
        return entity.getRemban71();
    }

    /**
     * 調査項目連番７２を返します。
     *
     * @return 調査項目連番７２
     */
    public int get項目連番72() {
        return entity.getRemban72();
    }

    /**
     * 調査項目連番７３を返します。
     *
     * @return 調査項目連番７３
     */
    public int get項目連番73() {
        return entity.getRemban73();
    }

    /**
     * 調査項目連番７４を返します。
     *
     * @return 調査項目連番７４
     */
    public int get項目連番74() {
        return entity.getRemban74();
    }

    /**
     * 調査項目連番７５を返します。
     *
     * @return 調査項目連番７５
     */
    public int get項目連番75() {
        return entity.getRemban75();
    }

    /**
     * 調査項目連番７６を返します。
     *
     * @return 調査項目連番７６
     */
    public int get項目連番76() {
        return entity.getRemban76();
    }

    /**
     * 調査項目連番７７を返します。
     *
     * @return 調査項目連番７７
     */
    public int get項目連番77() {
        return entity.getRemban77();
    }

    /**
     * 調査項目連番７８を返します。
     *
     * @return 調査項目連番７８
     */
    public int get項目連番78() {
        return entity.getRemban78();
    }

    /**
     * 調査項目連番７９を返します。
     *
     * @return 調査項目連番７９
     */
    public int get項目連番79() {
        return entity.getRemban79();
    }

    /**
     * 調査項目連番８０を返します。
     *
     * @return 調査項目連番８０
     */
    public int get項目連番80() {
        return entity.getRemban80();
    }

    /**
     * 調査項目連番８１を返します。
     *
     * @return 調査項目連番８１
     */
    public int get項目連番81() {
        return entity.getRemban81();
    }

    /**
     * 調査項目連番８２を返します。
     *
     * @return 調査項目連番８２
     */
    public int get項目連番82() {
        return entity.getRemban82();
    }

    /**
     * 調査項目連番８３を返します。
     *
     * @return 調査項目連番８３
     */
    public int get項目連番83() {
        return entity.getRemban83();
    }

    /**
     * 調査項目連番８４を返します。
     *
     * @return 調査項目連番８４
     */
    public int get項目連番84() {
        return entity.getRemban84();
    }

    /**
     * 調査項目連番８５を返します。
     *
     * @return 調査項目連番８５
     */
    public int get項目連番85() {
        return entity.getRemban85();
    }

    /**
     * 前回厚労省IF識別コードを返します。
     *
     * @return 前回厚労省IF識別コード
     */
    public Code get前回厚労省IF識別コード() {
        return entity.getZenkaiKoroshoIfShikibetsuCode();
    }

    /**
     * 前回認定調査・認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 前回認定調査・認知症高齢者の日常生活自立度コード
     */
    public Code get前回認知症高齢者の日常生活自立度コード() {
        return entity.getZenkaiNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 前回認定調査・障害高齢者の日常生活自立度コードを返します。
     *
     * @return 前回認定調査・障害高齢者の日常生活自立度コード
     */
    public Code get前回障害高齢者の日常生活自立度コード() {
        return entity.getZenkaiShogaiNichijoSeikatsuJiritsudoCode();
    }

}
