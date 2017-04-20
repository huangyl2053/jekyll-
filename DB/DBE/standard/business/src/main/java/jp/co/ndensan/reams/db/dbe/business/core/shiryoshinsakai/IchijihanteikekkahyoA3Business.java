/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.NitijouSeikatsu;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TiyosaKekka;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TokkiJikou;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.TyukanHyouka;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3423
 */
public class IchijihanteikekkahyoA3Business {

    private final IchijihanteikekkahyoA3Entity entity;
    private final boolean isJimu;

    /**
     * コンストラクタです。
     *
     * @param entity IchijihanteikekkahyoA3Entity
     * @param isJimu 事務局用かどうか
     */
    public IchijihanteikekkahyoA3Business(IchijihanteikekkahyoA3Entity entity, boolean isJimu) {
        this.entity = entity;
        this.isJimu = isJimu;
    }

    /**
     * 審査人数を取得します。
     *
     * @return 審査人数
     */
    public RString get審査人数() {
        return entity.get審査人数();
    }

    /**
     * 審査人数合計を取得します。
     *
     * @return 審査人数合計
     */
    public RString get審査人数合計() {
        return entity.get審査人数合計();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 被保険者区分を取得します。
     *
     * @return 被保険者区分
     */
    public RString get被保険者区分() {
        return entity.get被保険者区分();
    }

    /**
     * 申請区分を取得します。
     *
     * @return 申請区分
     */
    public RString get申請区分() {
        return entity.get申請区分();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return entity.get年齢();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 前々回要介護度を取得します。
     *
     * @return 前々回要介護度
     */
    public RString get前々回要介護度() {
        return entity.get前々回要介護度();
    }

    /**
     * 前々回認定有効期間を取得します。
     *
     * @return 前々回認定有効期間
     */
    public RString get前々回認定有効期間() {
        return entity.get前々回認定有効期間();
    }

    /**
     * 前々回認定有効期間開始年月日を取得します。
     *
     * @return 前々回認定有効期間開始年月日
     */
    public FlexibleDate get前々回認定有効期間開始年月日() {
        return entity.get前々回認定有効期間開始年月日();
    }

    /**
     * 前々回認定有効期間終了年月日を取得します。
     *
     * @return 前々回認定有効期間終了年月日
     */
    public FlexibleDate get前々回認定有効期間終了年月日() {
        return entity.get前々回認定有効期間終了年月日();
    }

    /**
     * 前回要介護度を取得します。
     *
     * @return 前回要介護度
     */
    public RString get前回要介護度() {
        return entity.get前回要介護度();
    }

    /**
     * 前回認定有効期間を取得します。
     *
     * @return 前回認定有効期間
     */
    public RString get前回認定有効期間() {
        return entity.get前回認定有効期間();
    }

    /**
     * 前回認定有効期間開始年月日を取得します。
     *
     * @return 前回認定有効期間開始年月日
     */
    public FlexibleDate get前回認定有効期間開始年月日() {
        return entity.get前回認定有効期間開始年月日();
    }

    /**
     * 前回認定有効期間終了年月日を取得します。
     *
     * @return 前回認定有効期間終了年月日
     */
    public FlexibleDate get前回認定有効期間終了年月日() {
        return entity.get前回認定有効期間終了年月日();
    }

    /**
     * 管理番号を取得します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        if (isJimu) {
            return entity.get管理番号();
        }
        return RString.EMPTY;
    }

    /**
     * 前回認定日を取得します。
     *
     * @return 前回認定日
     */
    public FlexibleDate get前回認定日() {
        return entity.get前回認定日();
    }

    /**
     * 前回状態像を取得します。
     *
     * @return 前回状態像
     */
    public RString get前回状態像() {
        return entity.get前回状態像();
    }

    /**
     * 審査会資料作成年月日を取得します。
     *
     * @return 審査会資料作成年月日
     */
    public FlexibleDate get審査会資料作成年月日() {
        return entity.get審査会資料作成年月日();
    }

    /**
     * 今回認定申請年月日を取得します。
     *
     * @return 今回認定申請年月日
     */
    public FlexibleDate get今回認定申請年月日() {
        return entity.get今回認定申請年月日();
    }

    /**
     * 今回認定調査実施年月日を取得します。
     *
     * @return 今回認定調査実施年月日
     */
    public FlexibleDate get今回認定調査実施年月日() {
        return entity.get今回認定調査実施年月日();
    }

    /**
     * 今回認定審査年月日を取得します。
     *
     * @return 今回認定審査年月日
     */
    public FlexibleDate get今回認定審査年月日() {
        return entity.get今回認定審査年月日();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        if (isJimu) {
            return entity.get被保険者番号();
        }
        return RString.EMPTY;
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        if (isJimu) {
            return entity.get保険者番号();
        }
        return RString.EMPTY;
    }

    /**
     * 市町村名を取得します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        return entity.get市町村名();
    }

    /**
     * 事業者番号を取得します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.get事業者番号();
    }

    /**
     * 事業者名を取得します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return entity.get事業者名();
    }

    /**
     * 認定調査員番号を取得します。
     *
     * @return 認定調査員番号
     */
    public RString get認定調査員番号() {
        return entity.get認定調査員番号();
    }

    /**
     * 認定調査員氏名を取得します。
     *
     * @return 認定調査員氏名
     */
    public RString get認定調査員氏名() {
        return entity.get認定調査員氏名();
    }

    /**
     * 調査員資格を取得します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.get調査員資格();
    }

    /**
     * SabisuKubunを取得します。
     *
     * @return SabisuKubun
     */
    public RString getSabisuKubun() {
        return entity.getSabisuKubun();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate get認定調査実施年月日() {
        return entity.get認定調査実施年月日();
    }

    /**
     * 特記事項_listChosa1を取得します。
     *
     * @return 特記事項_listChosa1
     */
    public List<TokkiJikou> get特記事項_listChosa1() {
        return entity.get特記事項_listChosa1();
    }

    /**
     * 電話番号テキストを取得します。
     *
     * @return 電話番号テキスト
     */
    public RString get電話番号テキスト() {
        return entity.get電話番号テキスト();
    }

    /**
     * 要介護認定等基準時間_認知症加算を取得します。
     *
     * @return 要介護認定等基準時間_認知症加算
     */
    public RString get要介護認定等基準時間_認知症加算() {
        return entity.get要介護認定等基準時間_認知症加算();
    }

    /**
     * SabisuKaisu6を取得します。
     *
     * @return SabisuKaisu6
     */
    public RString getサービス回数6() {
        return entity.getSabisuKaisu6();
    }

    /**
     * SabisuKaisu7を取得します。
     *
     * @return SabisuKaisu7
     */
    public RString getサービス回数7() {
        return entity.getSabisuKaisu7();
    }

    /**
     * SabisuKaisu8を取得します。
     *
     * @return SabisuKaisu8
     */
    public RString getサービス回数8() {
        return entity.getSabisuKaisu8();
    }

    /**
     * SabisuKaisu9を取得します。
     *
     * @return SabisuKaisu9
     */
    public RString getサービス回数9() {
        return entity.getSabisuKaisu9();
    }

    /**
     * 第４群リストを取得します。
     *
     * @return 第４群リスト
     */
    public List<TiyosaKekka> get第４群リスト() {
        return entity.get第４群リスト();
    }

    /**
     * 基準時間の積み上げグラフを取得します。
     *
     * @return 基準時間の積み上げグラフ
     */
    public RString get基準時間の積み上げグラフ() {
        return entity.get基準時間の積み上げグラフ();
    }

    /**
     * 主治医番号を取得します。
     *
     * @return 主治医番号
     */
    public RString get主治医番号() {
        return entity.get主治医番号();
    }

    /**
     * SabisuKaisu1を取得します。
     *
     * @return SabisuKaisu1
     */
    public RString getサービス回数1() {
        return entity.getSabisuKaisu1();
    }

    /**
     * 施設名イメージを取得します。
     *
     * @return 施設名イメージ
     */
    public RString get施設名イメージ() {
        return entity.get施設名イメージ();
    }

    /**
     * SabisuKaisu2を取得します。
     *
     * @return SabisuKaisu2
     */
    public RString getサービス回数2() {
        return entity.getSabisuKaisu2();
    }

    /**
     * SabisuKaisu3を取得します。
     *
     * @return SabisuKaisu3
     */
    public RString getサービス回数3() {
        return entity.getSabisuKaisu3();
    }

    /**
     * SabisuName1を取得します。
     *
     * @return SabisuName1
     */
    public RString getサービス名称1() {
        return entity.getSabisuName1();
    }

    /**
     * SabisuKaisu4を取得します。
     *
     * @return SabisuKaisu4
     */
    public RString getサービス回数4() {
        return entity.getSabisuKaisu4();
    }

    /**
     * SabisuKaisu5を取得します。
     *
     * @return SabisuKaisu5
     */
    public RString getサービス回数5() {
        return entity.getSabisuKaisu5();
    }

    /**
     * SabisuName5を取得します。
     *
     * @return SabisuName5
     */
    public RString getサービス名称5() {
        return entity.getSabisuName5();
    }

    /**
     * SabisuName4を取得します。
     *
     * @return SabisuName4
     */
    public RString getサービス名称4() {
        return entity.getSabisuName4();
    }

    /**
     * SabisuName3を取得します。
     *
     * @return SabisuName3
     */
    public RString getサービス名称3() {
        return entity.getSabisuName3();
    }

    /**
     * SabisuName2を取得します。
     *
     * @return SabisuName2
     */
    public RString getサービス名称2() {
        return entity.getSabisuName2();
    }

    /**
     * SabisuName9を取得します。
     *
     * @return SabisuName9
     */
    public RString getサービス名称9() {
        return entity.getSabisuName9();
    }

    /**
     * SabisuName8を取得します。
     *
     * @return SabisuName8
     */
    public RString getサービス名称8() {
        return entity.getSabisuName8();
    }

    /**
     * SabisuName7を取得します。
     *
     * @return SabisuName7
     */
    public RString getサービス名称7() {
        return entity.getSabisuName7();
    }

    /**
     * SabisuName6を取得します。
     *
     * @return SabisuName6
     */
    public RString getサービス名称6() {
        return entity.getSabisuName6();
    }

    /**
     * 状態の安定性を取得します。
     *
     * @return 状態の安定性
     */
    public RString get状態の安定性() {
        return entity.get状態の安定性();
    }

    /**
     * 警告コードを取得します。
     *
     * @return 警告コード
     */
    public RString get警告コード() {
        return entity.get警告コード();
    }

    /**
     * 第３群リストを取得します。
     *
     * @return 第３群リスト
     */
    public List<TiyosaKekka> get第３群リスト() {
        return entity.get第３群リスト();
    }

    /**
     * 審査番号を取得します。
     *
     * @return 審査番号
     */
    public int get審査番号() {
        return entity.get審査番号();
    }

    /**
     * 概況特記のイメージを取得します。
     *
     * @return 概況特記のイメージ
     */
    public RString get概況特記のイメージ() {
        return entity.get概況特記のイメージ();
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を取得します。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    public RString get認知症自立度Ⅱ以上の蓋然性() {
        return entity.get認知症自立度Ⅱ以上の蓋然性();
    }

    /**
     * SabisuKaisu21を取得します。
     *
     * @return SabisuKaisu21
     */
    public RString getサービス回数21() {
        return entity.getSabisuKaisu21();
    }

    /**
     * SabisuKaisu20を取得します。
     *
     * @return SabisuKaisu20
     */
    public RString getサービス回数20() {
        return entity.getSabisuKaisu20();
    }

    /**
     * 名前を取得します。
     *
     * @return 名前
     */
    public RString get名前() {
        return entity.get名前();
    }

    /**
     * SabisuKaisu13を取得します。
     *
     * @return SabisuKaisu13
     */
    public RString getサービス回数13() {
        return entity.getSabisuKaisu13();
    }

    /**
     * 認定調査結果認知症高齢者自立度を取得します。
     *
     * @return 認定調査結果認知症高齢者自立度
     */
    public RString get認定調査結果認知症高齢者自立度() {
        return entity.get認定調査結果認知症高齢者自立度();
    }

    /**
     * SabisuKaisu14を取得します。
     *
     * @return SabisuKaisu14
     */
    public RString getサービス回数14() {
        return entity.getSabisuKaisu14();
    }

    /**
     * SabisuKaisu15を取得します。
     *
     * @return SabisuKaisu15
     */
    public RString getサービス回数15() {
        return entity.getSabisuKaisu15();
    }

    /**
     * SabisuKaisu16を取得します。
     *
     * @return SabisuKaisu16
     */
    public RString getサービス回数16() {
        return entity.getSabisuKaisu16();
    }

    /**
     * SabisuKaisu17を取得します。
     *
     * @return SabisuKaisu17
     */
    public RString getサービス回数17() {
        return entity.getSabisuKaisu17();
    }

    /**
     * SabisuKaisu18を取得します。
     *
     * @return SabisuKaisu18
     */
    public RString getサービス回数18() {
        return entity.getSabisuKaisu18();
    }

    /**
     * 要介護認定等基準時間_食事を取得します。
     *
     * @return 要介護認定等基準時間_食事
     */
    public RString get要介護認定等基準時間_食事() {
        return entity.get要介護認定等基準時間_食事();
    }

    /**
     * SabisuKaisu19を取得します。
     *
     * @return SabisuKaisu19
     */
    public RString getサービス回数19() {
        return entity.getSabisuKaisu19();
    }

    /**
     * 住所テキストを取得します。
     *
     * @return 住所テキスト
     */
    public RString get住所テキスト() {
        return entity.get住所テキスト();
    }

    /**
     * 住所イメージを取得します。
     *
     * @return 住所イメージ
     */
    public RString get住所イメージ() {
        return entity.get住所イメージ();
    }

    /**
     * 主治医意見書を取得します。
     *
     * @return 主治医意見書
     */
    public List<TiyosaKekka> get主治医意見書() {
        return entity.get主治医意見書();
    }

    /**
     * 特記事項_tokkiImgを取得します。
     *
     * @return 特記事項_tokkiImg
     */
    public List<RString> get特記事項_tokkiImg() {
        return entity.get特記事項_tokkiImg();
    }

    /**
     * 特記事項被保険者番号を取得します。
     *
     * @return 特記事項被保険者番号
     */
    public RString get特記事項被保険者番号() {
        return entity.get特記事項被保険者番号();
    }

    /**
     * 日常生活自立度リストを取得します。
     *
     * @return 日常生活自立度リスト
     */
    public List<NitijouSeikatsu> get日常生活自立度リスト() {
        return entity.get日常生活自立度リスト();
    }

    /**
     * 要介護認定等基準時間_清潔保持を取得します。
     *
     * @return 要介護認定等基準時間_清潔保持
     */
    public RString get要介護認定等基準時間_清潔保持() {
        return entity.get要介護認定等基準時間_清潔保持();
    }

    /**
     * SabisuKaisu12を取得します。
     *
     * @return SabisuKaisu12
     */
    public RString getサービス回数12() {
        return entity.getSabisuKaisu12();
    }

    /**
     * SabisuKaisu11を取得します。
     *
     * @return SabisuKaisu11
     */
    public RString getサービス回数11() {
        return entity.getSabisuKaisu11();
    }

    /**
     * SabisuKaisu10を取得します。
     *
     * @return SabisuKaisu10
     */
    public RString getサービス回数10() {
        return entity.getSabisuKaisu10();
    }

    /**
     * SabisuName19を取得します。
     *
     * @return SabisuName19
     */
    public RString getサービス名称19() {
        return entity.getSabisuName19();
    }

    /**
     * 施設名テキストを取得します。
     *
     * @return 施設名テキスト
     */
    public RString get施設名テキスト() {
        return entity.get施設名テキスト();
    }

    /**
     * SabisuName17を取得します。
     *
     * @return SabisuName17
     */
    public RString getサービス名称17() {
        return entity.getSabisuName17();
    }

    /**
     * 要介護認定等基準時間_移動を取得します。
     *
     * @return 要介護認定等基準時間_移動
     */
    public RString get要介護認定等基準時間_移動() {
        return entity.get要介護認定等基準時間_移動();
    }

    /**
     * SabisuName18を取得します。
     *
     * @return SabisuName18
     */
    public RString getサービス名称18() {
        return entity.getSabisuName18();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * SabisuName11を取得します。
     *
     * @return SabisuName11
     */
    public RString getサービス名称11() {
        return entity.getSabisuName11();
    }

    /**
     * SabisuName12を取得します。
     *
     * @return SabisuName12
     */
    public RString getサービス名称12() {
        return entity.getSabisuName12();
    }

    /**
     * 特別な医療リスト１を取得します。
     *
     * @return 特別な医療リスト１
     */
    public List<TiyosaKekka> get特別な医療リスト１() {
        return entity.get特別な医療リスト１();
    }

    /**
     * 特別な医療リスト２を取得します。
     *
     * @return 特別な医療リスト２
     */
    public List<TiyosaKekka> get特別な医療リスト２() {
        return entity.get特別な医療リスト２();
    }

    /**
     * 特記事項_tokkiTextを取得します。
     *
     * @return 特記事項_tokkiText
     */
    public List<RString> get特記事項_tokkiText() {
        return entity.get特記事項_tokkiText();
    }

    /**
     * SabisuName10を取得します。
     *
     * @return SabisuName10
     */
    public RString getサービス名称10() {
        return entity.getSabisuName10();
    }

    /**
     * 調査日を取得します。
     *
     * @return 調査日
     */
    public FlexibleDate get調査日() {
        return entity.get調査日();
    }

    /**
     * SabisuName15を取得します。
     *
     * @return SabisuName15
     */
    public RString getサービス名称15() {
        return entity.getSabisuName15();
    }

    /**
     * SabisuName16を取得します。
     *
     * @return SabisuName16
     */
    public RString getサービス名称16() {
        return entity.getSabisuName16();
    }

    /**
     * SabisuName13を取得します。
     *
     * @return SabisuName13
     */
    public RString getサービス名称13() {
        return entity.getSabisuName13();
    }

    /**
     * 要介護認定等基準時間_機能訓練を取得します。
     *
     * @return 要介護認定等基準時間_機能訓練
     */
    public RString get要介護認定等基準時間_機能訓練() {
        return entity.get要介護認定等基準時間_機能訓練();
    }

    /**
     * SabisuName14を取得します。
     *
     * @return SabisuName14
     */
    public RString getサービス名称14() {
        return entity.getSabisuName14();
    }

    /**
     * 第５群リストを取得します。
     *
     * @return 第５群リスト
     */
    public List<TiyosaKekka> get第５群リスト() {
        return entity.get第５群リスト();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 前回要介護認定等基準時間を取得します。
     *
     * @return 前回要介護認定等基準時間
     */
    public RString get前回要介護認定等基準時間() {
        return entity.get前回要介護認定等基準時間();
    }

    /**
     * 概況特記のテキストを取得します。
     *
     * @return 概況特記のテキスト
     */
    public RString get概況特記のテキスト() {
        return entity.get概況特記のテキスト();
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 特記事項テキスト_イメージ区分を取得します。
     *
     * @return 特記事項テキスト_イメージ区分
     */
    public RString get特記事項テキスト_イメージ区分() {
        return entity.get特記事項テキスト_イメージ区分();
    }

    /**
     * 給付区分を取得します。
     *
     * @return 給付区分
     */
    public RString get給付区分() {
        return entity.get給付区分();
    }

    /**
     * 要介護認定等基準時間_医療関連を取得します。
     *
     * @return 要介護認定等基準時間_医療関連
     */
    public RString get要介護認定等基準時間_医療関連() {
        return entity.get要介護認定等基準時間_医療関連();
    }

    /**
     * 要介護認定等基準時間を取得します。
     *
     * @return 要介護認定等基準時間
     */
    public RString get要介護認定等基準時間() {
        return entity.get要介護認定等基準時間();
    }

    /**
     * SabisuName20を取得します。
     *
     * @return SabisuName20
     */
    public RString getサービス名称20() {
        return entity.getSabisuName20();
    }

    /**
     * SabisuName21を取得します。
     *
     * @return SabisuName21
     */
    public RString getサービス名称21() {
        return entity.getSabisuName21();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 特定疾病名を取得します。
     *
     * @return 特定疾病名
     */
    public RString get特定疾病名() {
        return entity.get特定疾病名();
    }

    /**
     * 電話番号イメージを取得します。
     *
     * @return 電話番号イメージ
     */
    public RString get電話番号イメージ() {
        return entity.get電話番号イメージ();
    }

    /**
     * 介護認定審査会開催年月日を取得します。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate get介護認定審査会開催年月日() {
        return entity.get介護認定審査会開催年月日();
    }

    /**
     * 第２群リストを取得します。
     *
     * @return 第２群リスト
     */
    public List<TiyosaKekka> get第２群リスト() {
        return entity.get第２群リスト();
    }

    /**
     * serviceKubunCodeを取得します。
     *
     * @return ServiceKubunCode
     */
    public Code getServiceKubunCode() {
        return entity.getServiceKubunCode();
    }

    /**
     * 特記パターンを取得します。
     *
     * @return 特記パターン
     */
    public RString get特記パターン() {
        return entity.get特記パターン();
    }

    /**
     * 第１群リストを取得します。
     *
     * @return 第１群リスト
     */
    public List<TiyosaKekka> get第１群リスト() {
        return entity.get第１群リスト();
    }

    /**
     * 概況調査テキスト_イメージ区分を取得します。
     *
     * @return 概況調査テキスト_イメージ区分
     */
    public RString get概況調査テキスト_イメージ区分() {
        return entity.get概況調査テキスト_イメージ区分();
    }

    /**
     * 調査実施場所を取得します。
     *
     * @return 調査実施場所
     */
    public RString get調査実施場所() {
        return entity.get調査実施場所();
    }

    /**
     * 要介護認定等基準時間_排泄を取得します。
     *
     * @return 要介護認定等基準時間_排泄
     */
    public RString get要介護認定等基準時間_排泄() {
        return entity.get要介護認定等基準時間_排泄();
    }

    /**
     * 要介護認定等基準時間_間接を取得します。
     *
     * @return 要介護認定等基準時間_間接
     */
    public RString get要介護認定等基準時間_間接() {
        return entity.get要介護認定等基準時間_間接();
    }

    /**
     * 特記事項保険者番号を取得します。
     *
     * @return 特記事項保険者番号
     */
    public RString get特記事項保険者番号() {
        return entity.get特記事項保険者番号();
    }

    /**
     * 医療機関番号を取得します。
     *
     * @return 医療機関番号
     */
    public RString get医療機関番号() {
        return entity.get医療機関番号();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 中間評価リストを取得します。
     *
     * @return 中間評価リスト
     */
    public List<TyukanHyouka> get中間評価リスト() {
        return entity.get中間評価リスト();
    }

    /**
     * 意見書認知症高齢者自立度を取得します。
     *
     * @return 意見書認知症高齢者自立度
     */
    public RString get意見書認知症高齢者自立度() {
        return entity.get意見書認知症高齢者自立度();
    }

    /**
     * 要介護認定等基準時間_BPSD関連を取得します。
     *
     * @return 要介護認定等基準時間_BPSD関連
     */
    public RString get要介護認定等基準時間_BPSD関連() {
        return entity.get要介護認定等基準時間_BPSD関連();
    }

    /**
     * 一次判定結果を取得します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        return entity.get一次判定結果();
    }

    /**
     * 凡例文言1を取得します。
     *
     * @return 凡例1
     */
    public RString get凡例1() {
        return entity.get凡例1();
    }

    /**
     * 凡例文言2を取得します。
     *
     * @return 凡例2
     */
    public RString get凡例2() {
        return entity.get凡例2();
    }

    /**
     * 凡例文言3を取得します。
     *
     * @return 凡例3
     */
    public RString get凡例3() {
        return entity.get凡例3();
    }

    /**
     * 凡例文言4を取得します。
     *
     * @return 凡例4
     */
    public RString get凡例4() {
        return entity.get凡例4();
    }

    /**
     * 凡例文言5を取得します。
     *
     * @return 凡例5
     */
    public RString get凡例5() {
        return entity.get凡例5();
    }

    /**
     * 凡例文言6を取得します。
     *
     * @return 凡例6
     */
    public RString get凡例6() {
        return entity.get凡例6();
    }

    /**
     * 前回結果の認定ソフトバージョン記号を取得します。
     *
     * @return 前回結果の認定ソフトバージョン記号
     */
    public RString get前回結果バージョン記号() {
        if (isJimu) {
            return entity.get前回結果バージョン記号();
        }
        return RString.EMPTY;
    }

    /**
     * @return 利用施設種類
     */
    public RString get利用施設種類() {
        return entity.get利用施設種類();
    }
}
