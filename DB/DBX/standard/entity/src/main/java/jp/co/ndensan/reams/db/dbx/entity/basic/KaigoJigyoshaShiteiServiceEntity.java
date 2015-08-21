/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.basic;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 介護事業者指定サービスマスタの内容を持つエンティティです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者指定サービスエンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0521KaigoJigyoshaShiteiServiceEntity}を使用してください。
 */
@OnRshareSchema
public class KaigoJigyoshaShiteiServiceEntity {
    //TODO n2818西澤貴幸 DBテーブルができたら置き換え 2014/1/31期限

    private RString 事業者番号;
    private RString 指定基準該当等事業所区分;
    private RString 指定番号;
    private RString 管理者氏名カナ;
    private RString 管理者氏名;
    private RString 管理者電話番号;
    private RString 管理者住所郵便番号;
    private RString 管理者住所カナ;
    private RString 管理者住所;
    private RDate 事業開始年月日;
    private RDate 事業休止年月日;
    private RDate 事業廃止年月日;
    private RDate 事業再開年月日;
    private RString 施設等の区分;
    private RString 人員配置区分;
    private Boolean 機能訓練指導体制の有無;
    private Boolean 食事提供体制の有無;
    private Boolean 入浴介助体制の有無;
    private Boolean 特別入浴介助体制の有無;
    private Boolean 常勤専従医師配置の有無;
    private RString 医師の配置基準;
    private Boolean 精神科医師定期的療養指導の有無;
    private RString 夜間勤務条件基準;
    private Boolean 認知症専門棟の有無;
    private RString 食事提供の状況;
    private RString 送迎体制;
    private Boolean リハビリテーション提供体制総合リハビリテーション施設の有無;
    private Boolean リハビリテーション提供体制理学療法Ⅱの有無;
    private Boolean リハビリテーション提供体制理学療法Ⅲの有無;
    private Boolean リハビリテーション提供体制作業療法Ⅱの有無;
    private Boolean リハビリテーション提供体制精神科作業療法の有無;
    private Boolean リハビリテーション提供体制その他の有無;
    private Boolean リハビリテーションの加算状況の有無;
    private RString 療養環境基準;
    private Boolean 医師の欠員による減算の状況の有無;
    private Boolean 看護職員の欠員による減算の状況の有無;
    private Boolean 理学療法士の欠員による減算の状況の有無;
    private Boolean 作業療法士の欠員による減算の状況の有無;
    private Boolean 介護職員の欠員による減算の状況の有無;
    private Boolean 介護支援専門員の欠員による減算の状況の有無;
    private Boolean 介護従業者の欠員による減算の状況の有無;
    private Boolean 感染対策指導管理の有無;
    private Boolean 重症皮膚潰瘍指導管理の有無;
    private Boolean 薬剤管理指導の有無;
    private Boolean 障害者生活支援体制の有無;
    private Boolean 生活保護法による指定の有無;
    private RString 地域区分コード;
    private RString 登録保険者番号;
    private Boolean 受領委任の有無;
    private RDate 登録開始年月日;
    private RDate 登録終了年月日;
    private RString 時間延長サービス体制;
    private RString 個別リハビリテーション提供体制;
    private RString 居住費対策;
    private Boolean 夜間ケアの有無;
    private Boolean リハビリテーション機能強化の有無;
    private Boolean 個別リハビリ提供体制総合リハビリテーション施設の有無;
    private Boolean 個別リハビリテーション提供体制理学療法Ⅱの有無1;
    private Boolean 個別リハビリテーション提供体制理学療法Ⅲの有無;
    private Boolean 個別リハビリテーション提供体制作業療法Ⅱの有無;
    private Boolean 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無;
    private Boolean 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無;
    private Boolean 言語聴覚士の欠員による減算の状況の有無;
    private RString 栄養管理の評価;
    private Boolean 社会福祉法人軽減事業実施の有無;
    private Boolean 特定事業所加算訪問介護の有無;
    private Boolean 若年性認知症ケア体制の有無;
    private Boolean 運動器機能向上体制の有無;
    private Boolean 栄養マネジメント改善体制の有無;
    private Boolean 口腔機能向上体制の有無;
    private Boolean 事業所評価加算申出の有無;
    private Boolean 事業所評価加算決定の有無;
    private Boolean 緊急受入体制の有無;
    private Boolean 夜間看護体制の有無;
    private Boolean 特定事業所加算居宅介護支援の有無;
    private Integer 介護支援専門員数専従の常勤者;
    private Integer 介護支援専門員数専従の非常勤者;
    private Integer 介護支援専門員数兼務の常勤者;
    private Integer 介護支援専門員数兼務の非常勤者;
    private Integer 訪問介護サービス提供責任者数;
    private Integer 訪問介護員数専従の常勤者;
    private Integer 訪問介護員数専従の非常勤者;
    private Integer 訪問介護員数兼務の常勤者;
    private Integer 訪問介護員数兼務の非常勤者;
    private Integer 訪問介護員数常勤換算後の人数;
    private Integer 利用定員数;
    private RString 指定更新申請中区分;
    private RDate 効力停止開始年月日;
    private RDate 効力停止終了年月日;
    private Boolean 大規模事業所該当の有無;
    private Boolean 準ユニットケア体制の有無;
    private Boolean 重度化対応体制の有無;
    private Boolean 医療連携体制の有無;
    private Boolean ユニットケア体制の有無;
    private Boolean 在宅入所相互利用体制の有無;
    private Boolean ターミナルケア体制看取り介護体制の有無;
    private Boolean 身体拘束廃止取組の有無;
    private Boolean 小規模拠点集合体制の有無;
    private Boolean 認知症ケア加算の有無;
    private Boolean 個別機能訓練体制の有無;
    private Boolean 個別リハビリテーション提供体制理学療法Ⅰの有無;
    private Boolean 個別リハビリテーション提供体制理学療法Ⅱの有無2;
    private Boolean 個別リハビリテーション提供体制作業療法の有無;
    private Boolean 個別リハビリテーション提供体制言語聴覚療法の有無;
    private Boolean 個別リハビリテーション提供体制その他の有無;
    private RString 設備基準;
    private RString 療養体制維持特別加算;
    private Boolean 個別リハビリ提供体制リハビリテーション指導管理の有無;
    private RString 三級ヘルパー体制;
    private RString 中山間地域等における小規模事業所加算地域に関する状況;
    private RString 中山間地域等における小規模事業所加算規模に関する状況;
    private RString サービス提供体制強化加算;
    private RString 認知症短期集中リハビリテーション加算;
    private RString 若年性認知症利用者入所者患者受入加算;
    private RString 看護体制加算;
    private RString 夜勤職員配置加算;
    private RString 療養食加算;
    private RString 日常生活継続支援加算;
    private RString 認知症専門ケア加算;
    private RString 二十四時間通報対応加算;
    private RString 看護職員配置加算;
    private RString 夜間ケア加算;
    private Boolean 集団コミュニケーション療法の有無;
    private RString サービス提供体制強化加算空床型;
    private Boolean 日中の身体介護２０分未満体制の有無;
    private Boolean サービス提供責任者体制の有無;
    private Boolean 同一建物に居住する利用者の減算の有無;
    private RString 緊急短期入所体制確保加算;
    private RString 在宅復帰在宅療養支援機能加算;
    private RString 生活機能向上グループ活動加算;
    private RString 介護職員処遇改善加算;

    /**
     * @return the 指定基準該当等事業所区分
     */
    public RString get指定基準該当等事業所区分() {
        return 指定基準該当等事業所区分;
    }

    /**
     * @return the 指定番号
     */
    public RString get指定番号() {
        return 指定番号;
    }

    /**
     * @return the 管理者氏名カナ
     */
    public RString get管理者氏名カナ() {
        return 管理者氏名カナ;
    }

    /**
     * @return the 管理者氏名
     */
    public RString get管理者氏名() {
        return 管理者氏名;
    }

    /**
     * @return the 管理者電話番号
     */
    public RString get管理者電話番号() {
        return 管理者電話番号;
    }

    /**
     * @return the 管理者住所郵便番号
     */
    public RString get管理者住所郵便番号() {
        return 管理者住所郵便番号;
    }

    /**
     * @return the 管理者住所カナ
     */
    public RString get管理者住所カナ() {
        return 管理者住所カナ;
    }

    /**
     * @return the 管理者住所
     */
    public RString get管理者住所() {
        return 管理者住所;
    }

    /**
     * @return the 事業開始年月日
     */
    public RDate get事業開始年月日() {
        return 事業開始年月日;
    }

    /**
     * @return the 事業休止年月日
     */
    public RDate get事業休止年月日() {
        return 事業休止年月日;
    }

    /**
     * @return the 事業廃止年月日
     */
    public RDate get事業廃止年月日() {
        return 事業廃止年月日;
    }

    /**
     * @return the 事業再開年月日
     */
    public RDate get事業再開年月日() {
        return 事業再開年月日;
    }

    /**
     * @return the 施設等の区分
     */
    public RString get施設等の区分() {
        return 施設等の区分;
    }

    /**
     * @return the 人員配置区分
     */
    public RString get人員配置区分() {
        return 人員配置区分;
    }

    /**
     * @return the 機能訓練指導体制の有無
     */
    public Boolean get機能訓練指導体制の有無() {
        return 機能訓練指導体制の有無;
    }

    /**
     * @return the 食事提供体制の有無
     */
    public Boolean get食事提供体制の有無() {
        return 食事提供体制の有無;
    }

    /**
     * @return the 入浴介助体制の有無
     */
    public Boolean get入浴介助体制の有無() {
        return 入浴介助体制の有無;
    }

    /**
     * @return the 特別入浴介助体制の有無
     */
    public Boolean get特別入浴介助体制の有無() {
        return 特別入浴介助体制の有無;
    }

    /**
     * @return the 常勤専従医師配置の有無
     */
    public Boolean get常勤専従医師配置の有無() {
        return 常勤専従医師配置の有無;
    }

    /**
     * @return the 医師の配置基準
     */
    public RString get医師の配置基準() {
        return 医師の配置基準;
    }

    /**
     * @return the 精神科医師定期的療養指導の有無
     */
    public Boolean get精神科医師定期的療養指導の有無() {
        return 精神科医師定期的療養指導の有無;
    }

    /**
     * @return the 夜間勤務条件基準
     */
    public RString get夜間勤務条件基準() {
        return 夜間勤務条件基準;
    }

    /**
     * @return the 認知症専門棟の有無
     */
    public Boolean get認知症専門棟の有無() {
        return 認知症専門棟の有無;
    }

    /**
     * @return the 食事提供の状況
     */
    public RString get食事提供の状況() {
        return 食事提供の状況;
    }

    /**
     * @return the 送迎体制
     */
    public RString get送迎体制() {
        return 送迎体制;
    }

    /**
     * @return the リハビリテーション提供体制総合リハビリテーション施設の有無
     */
    public Boolean getリハビリテーション提供体制総合リハビリテーション施設の有無() {
        return リハビリテーション提供体制総合リハビリテーション施設の有無;
    }

    /**
     * @return the リハビリテーション提供体制理学療法Ⅱの有無
     */
    public Boolean getリハビリテーション提供体制理学療法Ⅱの有無() {
        return リハビリテーション提供体制理学療法Ⅱの有無;
    }

    /**
     * @return the リハビリテーション提供体制理学療法Ⅲの有無
     */
    public Boolean getリハビリテーション提供体制理学療法Ⅲの有無() {
        return リハビリテーション提供体制理学療法Ⅲの有無;
    }

    /**
     * @return the リハビリテーション提供体制作業療法Ⅱの有無
     */
    public Boolean getリハビリテーション提供体制作業療法Ⅱの有無() {
        return リハビリテーション提供体制作業療法Ⅱの有無;
    }

    /**
     * @return the リハビリテーション提供体制精神科作業療法の有無
     */
    public Boolean getリハビリテーション提供体制精神科作業療法の有無() {
        return リハビリテーション提供体制精神科作業療法の有無;
    }

    /**
     * @return the リハビリテーション提供体制その他の有無
     */
    public Boolean getリハビリテーション提供体制その他の有無() {
        return リハビリテーション提供体制その他の有無;
    }

    /**
     * @return the リハビリテーションの加算状況の有無
     */
    public Boolean getリハビリテーションの加算状況の有無() {
        return リハビリテーションの加算状況の有無;
    }

    /**
     * @return the 療養環境基準
     */
    public RString get療養環境基準() {
        return 療養環境基準;
    }

    /**
     * @return the 医師の欠員による減算の状況の有無
     */
    public Boolean get医師の欠員による減算の状況の有無() {
        return 医師の欠員による減算の状況の有無;
    }

    /**
     * @return the 看護職員の欠員による減算の状況の有無
     */
    public Boolean get看護職員の欠員による減算の状況の有無() {
        return 看護職員の欠員による減算の状況の有無;
    }

    /**
     * @return the 理学療法士の欠員による減算の状況の有無
     */
    public Boolean get理学療法士の欠員による減算の状況の有無() {
        return 理学療法士の欠員による減算の状況の有無;
    }

    /**
     * @return the 作業療法士の欠員による減算の状況の有無
     */
    public Boolean get作業療法士の欠員による減算の状況の有無() {
        return 作業療法士の欠員による減算の状況の有無;
    }

    /**
     * @return the 介護職員の欠員による減算の状況の有無
     */
    public Boolean get介護職員の欠員による減算の状況の有無() {
        return 介護職員の欠員による減算の状況の有無;
    }

    /**
     * @return the 介護支援専門員の欠員による減算の状況の有無
     */
    public Boolean get介護支援専門員の欠員による減算の状況の有無() {
        return 介護支援専門員の欠員による減算の状況の有無;
    }

    /**
     * @return the 介護従業者の欠員による減算の状況の有無
     */
    public Boolean get介護従業者の欠員による減算の状況の有無() {
        return 介護従業者の欠員による減算の状況の有無;
    }

    /**
     * @return the 感染対策指導管理の有無
     */
    public Boolean get感染対策指導管理の有無() {
        return 感染対策指導管理の有無;
    }

    /**
     * @return the 重症皮膚潰瘍指導管理の有無
     */
    public Boolean get重症皮膚潰瘍指導管理の有無() {
        return 重症皮膚潰瘍指導管理の有無;
    }

    /**
     * @return the 薬剤管理指導の有無
     */
    public Boolean get薬剤管理指導の有無() {
        return 薬剤管理指導の有無;
    }

    /**
     * @return the 障害者生活支援体制の有無
     */
    public Boolean get障害者生活支援体制の有無() {
        return 障害者生活支援体制の有無;
    }

    /**
     * @return the 生活保護法による指定の有無
     */
    public Boolean get生活保護法による指定の有無() {
        return 生活保護法による指定の有無;
    }

    /**
     * @return the 地域区分コード
     */
    public RString get地域区分コード() {
        return 地域区分コード;
    }

    /**
     * @return the 登録保険者番号
     */
    public RString get登録保険者番号() {
        return 登録保険者番号;
    }

    /**
     * @return the 受領委任の有無
     */
    public Boolean get受領委任の有無() {
        return 受領委任の有無;
    }

    /**
     * @return the 登録開始年月日
     */
    public RDate get登録開始年月日() {
        return 登録開始年月日;
    }

    /**
     * @return the 登録終了年月日
     */
    public RDate get登録終了年月日() {
        return 登録終了年月日;
    }

    /**
     * @return the 時間延長サービス体制
     */
    public RString get時間延長サービス体制() {
        return 時間延長サービス体制;
    }

    /**
     * @return the 個別リハビリテーション提供体制
     */
    public RString get個別リハビリテーション提供体制() {
        return 個別リハビリテーション提供体制;
    }

    /**
     * @return the 居住費対策
     */
    public RString get居住費対策() {
        return 居住費対策;
    }

    /**
     * @return the 夜間ケアの有無
     */
    public Boolean get夜間ケアの有無() {
        return 夜間ケアの有無;
    }

    /**
     * @return the リハビリテーション機能強化の有無
     */
    public Boolean getリハビリテーション機能強化の有無() {
        return リハビリテーション機能強化の有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制総合リハビリテーション施設の有無
     */
    public Boolean get個別リハビリテーション提供体制総合リハビリテーション施設の有無() {
        return 個別リハビリ提供体制総合リハビリテーション施設の有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制理学療法Ⅱの有無1
     */
    public Boolean get個別リハビリテーション提供体制理学療法Ⅱの有無1() {
        return 個別リハビリテーション提供体制理学療法Ⅱの有無1;
    }

    /**
     * @return the 個別リハビリテーション提供体制理学療法Ⅲの有無
     */
    public Boolean get個別リハビリテーション提供体制理学療法Ⅲの有無() {
        return 個別リハビリテーション提供体制理学療法Ⅲの有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制作業療法Ⅱの有無
     */
    public Boolean get個別リハビリテーション提供体制作業療法Ⅱの有無() {
        return 個別リハビリテーション提供体制作業療法Ⅱの有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無
     */
    public Boolean get個別リハビリテーション提供体制言語聴覚療法Ⅰの有無() {
        return 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無
     */
    public Boolean get個別リハビリテーション提供体制言語聴覚療法Ⅱの有無() {
        return 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無;
    }

    /**
     * @return the 言語聴覚士の欠員による減算の状況の有無
     */
    public Boolean get言語聴覚士の欠員による減算の状況の有無() {
        return 言語聴覚士の欠員による減算の状況の有無;
    }

    /**
     * @return the 栄養管理の評価
     */
    public RString get栄養管理の評価() {
        return 栄養管理の評価;
    }

    /**
     * @return the 社会福祉法人軽減事業実施の有無
     */
    public Boolean get社会福祉法人軽減事業実施の有無() {
        return 社会福祉法人軽減事業実施の有無;
    }

    /**
     * @return the 特定事業所加算訪問介護の有無
     */
    public Boolean get特定事業所加算訪問介護の有無() {
        return 特定事業所加算訪問介護の有無;
    }

    /**
     * @return the 若年性認知症ケア体制の有無
     */
    public Boolean get若年性認知症ケア体制の有無() {
        return 若年性認知症ケア体制の有無;
    }

    /**
     * @return the 運動器機能向上体制の有無
     */
    public Boolean get運動器機能向上体制の有無() {
        return 運動器機能向上体制の有無;
    }

    /**
     * @return the 栄養マネジメント改善体制の有無
     */
    public Boolean get栄養マネジメント改善体制の有無() {
        return 栄養マネジメント改善体制の有無;
    }

    /**
     * @return the 口腔機能向上体制の有無
     */
    public Boolean get口腔機能向上体制の有無() {
        return 口腔機能向上体制の有無;
    }

    /**
     * @return the 事業所評価加算申出の有無
     */
    public Boolean get事業所評価加算申出の有無() {
        return 事業所評価加算申出の有無;
    }

    /**
     * @return the 事業所評価加算決定の有無
     */
    public Boolean get事業所評価加算決定の有無() {
        return 事業所評価加算決定の有無;
    }

    /**
     * @return the 緊急受入体制の有無
     */
    public Boolean get緊急受入体制の有無() {
        return 緊急受入体制の有無;
    }

    /**
     * @return the 夜間看護体制の有無
     */
    public Boolean get夜間看護体制の有無() {
        return 夜間看護体制の有無;
    }

    /**
     * @return the 特定事業所加算居宅介護支援の有無
     */
    public Boolean get特定事業所加算居宅介護支援の有無() {
        return 特定事業所加算居宅介護支援の有無;
    }

    /**
     * @return the 介護支援専門員数専従の常勤者
     */
    public Integer get介護支援専門員数専従の常勤者() {
        return 介護支援専門員数専従の常勤者;
    }

    /**
     * @return the 介護支援専門員数専従の非常勤者
     */
    public Integer get介護支援専門員数専従の非常勤者() {
        return 介護支援専門員数専従の非常勤者;
    }

    /**
     * @return the 介護支援専門員数兼務の常勤者
     */
    public Integer get介護支援専門員数兼務の常勤者() {
        return 介護支援専門員数兼務の常勤者;
    }

    /**
     * @return the 介護支援専門員数兼務の非常勤者
     */
    public Integer get介護支援専門員数兼務の非常勤者() {
        return 介護支援専門員数兼務の非常勤者;
    }

    /**
     * @return the 訪問介護サービス提供責任者数
     */
    public Integer get訪問介護サービス提供責任者数() {
        return 訪問介護サービス提供責任者数;
    }

    /**
     * @return the 訪問介護員数専従の常勤者
     */
    public Integer get訪問介護員数専従の常勤者() {
        return 訪問介護員数専従の常勤者;
    }

    /**
     * @return the 訪問介護員数専従の非常勤者
     */
    public Integer get訪問介護員数専従の非常勤者() {
        return 訪問介護員数専従の非常勤者;
    }

    /**
     * @return the 訪問介護員数兼務の常勤者
     */
    public Integer get訪問介護員数兼務の常勤者() {
        return 訪問介護員数兼務の常勤者;
    }

    /**
     * @return the 訪問介護員数兼務の非常勤者
     */
    public Integer get訪問介護員数兼務の非常勤者() {
        return 訪問介護員数兼務の非常勤者;
    }

    /**
     * @return the 訪問介護員数常勤換算後の人数
     */
    public Integer get訪問介護員数常勤換算後の人数() {
        return 訪問介護員数常勤換算後の人数;
    }

    /**
     * @return the 利用定員数
     */
    public Integer get利用定員数() {
        return 利用定員数;
    }

    /**
     * @return the 指定更新申請中区分
     */
    public RString get指定更新申請中区分() {
        return 指定更新申請中区分;
    }

    /**
     * @return the 効力停止開始年月日
     */
    public RDate get効力停止開始年月日() {
        return 効力停止開始年月日;
    }

    /**
     * @return the 効力停止終了年月日
     */
    public RDate get効力停止終了年月日() {
        return 効力停止終了年月日;
    }

    /**
     * @return the 大規模事業所該当の有無
     */
    public Boolean get大規模事業所該当の有無() {
        return 大規模事業所該当の有無;
    }

    /**
     * @return the 準ユニットケア体制の有無
     */
    public Boolean get準ユニットケア体制の有無() {
        return 準ユニットケア体制の有無;
    }

    /**
     * @return the 重度化対応体制の有無
     */
    public Boolean get重度化対応体制の有無() {
        return 重度化対応体制の有無;
    }

    /**
     * @return the 医療連携体制の有無
     */
    public Boolean get医療連携体制の有無() {
        return 医療連携体制の有無;
    }

    /**
     * @return the ユニットケア体制の有無
     */
    public Boolean getユニットケア体制の有無() {
        return ユニットケア体制の有無;
    }

    /**
     * @return the 在宅入所相互利用体制の有無
     */
    public Boolean get在宅入所相互利用体制の有無() {
        return 在宅入所相互利用体制の有無;
    }

    /**
     * @return the ターミナルケア体制看取り介護体制の有無
     */
    public Boolean getターミナルケア体制看取り介護体制の有無() {
        return ターミナルケア体制看取り介護体制の有無;
    }

    /**
     * @return the 身体拘束廃止取組の有無
     */
    public Boolean get身体拘束廃止取組の有無() {
        return 身体拘束廃止取組の有無;
    }

    /**
     * @return the 小規模拠点集合体制の有無
     */
    public Boolean get小規模拠点集合体制の有無() {
        return 小規模拠点集合体制の有無;
    }

    /**
     * @return the 認知症ケア加算の有無
     */
    public Boolean get認知症ケア加算の有無() {
        return 認知症ケア加算の有無;
    }

    /**
     * @return the 個別機能訓練体制の有無
     */
    public Boolean get個別機能訓練体制の有無() {
        return 個別機能訓練体制の有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制理学療法Ⅰの有無
     */
    public Boolean get個別リハビリテーション提供体制理学療法Ⅰの有無() {
        return 個別リハビリテーション提供体制理学療法Ⅰの有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制理学療法Ⅱの有無2
     */
    public Boolean get個別リハビリテーション提供体制理学療法Ⅱの有無2() {
        return 個別リハビリテーション提供体制理学療法Ⅱの有無2;
    }

    /**
     * @return the 個別リハビリテーション提供体制作業療法の有無
     */
    public Boolean get個別リハビリテーション提供体制作業療法の有無() {
        return 個別リハビリテーション提供体制作業療法の有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制言語聴覚療法の有無
     */
    public Boolean get個別リハビリテーション提供体制言語聴覚療法の有無() {
        return 個別リハビリテーション提供体制言語聴覚療法の有無;
    }

    /**
     * @return the 個別リハビリテーション提供体制その他の有無
     */
    public Boolean get個別リハビリテーション提供体制その他の有無() {
        return 個別リハビリテーション提供体制その他の有無;
    }

    /**
     * @return the 設備基準
     */
    public RString get設備基準() {
        return 設備基準;
    }

    /**
     * @return the 療養体制維持特別加算
     */
    public RString get療養体制維持特別加算() {
        return 療養体制維持特別加算;
    }

    /**
     * @return the 個別リハビリテーション提供体制リハビリテーション指導管理の有無
     */
    public Boolean get個別リハビリテーション提供体制リハビリテーション指導管理の有無() {
        return 個別リハビリ提供体制リハビリテーション指導管理の有無;
    }

    /**
     * @return the 三級ヘルパー体制
     */
    public RString get三級ヘルパー体制() {
        return 三級ヘルパー体制;
    }

    /**
     * @return the 中山間地域等における小規模事業所加算地域に関する状況
     */
    public RString get中山間地域等における小規模事業所加算地域に関する状況() {
        return 中山間地域等における小規模事業所加算地域に関する状況;
    }

    /**
     * @return the 中山間地域等における小規模事業所加算規模に関する状況
     */
    public RString get中山間地域等における小規模事業所加算規模に関する状況() {
        return 中山間地域等における小規模事業所加算規模に関する状況;
    }

    /**
     * @return the サービス提供体制強化加算
     */
    public RString getサービス提供体制強化加算() {
        return サービス提供体制強化加算;
    }

    /**
     * @return the 認知症短期集中リハビリテーション加算
     */
    public RString get認知症短期集中リハビリテーション加算() {
        return 認知症短期集中リハビリテーション加算;
    }

    /**
     * @return the 若年性認知症利用者入所者患者受入加算
     */
    public RString get若年性認知症利用者入所者患者受入加算() {
        return 若年性認知症利用者入所者患者受入加算;
    }

    /**
     * @return the 看護体制加算
     */
    public RString get看護体制加算() {
        return 看護体制加算;
    }

    /**
     * @return the 夜勤職員配置加算
     */
    public RString get夜勤職員配置加算() {
        return 夜勤職員配置加算;
    }

    /**
     * @return the 療養食加算
     */
    public RString get療養食加算() {
        return 療養食加算;
    }

    /**
     * @return the 日常生活継続支援加算
     */
    public RString get日常生活継続支援加算() {
        return 日常生活継続支援加算;
    }

    /**
     * @return the 認知症専門ケア加算
     */
    public RString get認知症専門ケア加算() {
        return 認知症専門ケア加算;
    }

    /**
     * @return the 二十四時間通報対応加算
     */
    public RString get二十四時間通報対応加算() {
        return 二十四時間通報対応加算;
    }

    /**
     * @return the 看護職員配置加算
     */
    public RString get看護職員配置加算() {
        return 看護職員配置加算;
    }

    /**
     * @return the 夜間ケア加算
     */
    public RString get夜間ケア加算() {
        return 夜間ケア加算;
    }

    /**
     * @return the 集団コミュニケーション療法の有無
     */
    public Boolean get集団コミュニケーション療法の有無() {
        return 集団コミュニケーション療法の有無;
    }

    /**
     * @return the サービス提供体制強化加算空床型
     */
    public RString getサービス提供体制強化加算空床型() {
        return サービス提供体制強化加算空床型;
    }

    /**
     * @return the 日中の身体介護２０分未満体制の有無
     */
    public Boolean get日中の身体介護２０分未満体制の有無() {
        return 日中の身体介護２０分未満体制の有無;
    }

    /**
     * @return the サービス提供責任者体制の有無
     */
    public Boolean getサービス提供責任者体制の有無() {
        return サービス提供責任者体制の有無;
    }

    /**
     * @return the 同一建物に居住する利用者の減算の有無
     */
    public Boolean get同一建物に居住する利用者の減算の有無() {
        return 同一建物に居住する利用者の減算の有無;
    }

    /**
     * @return the 緊急短期入所体制確保加算
     */
    public RString get緊急短期入所体制確保加算() {
        return 緊急短期入所体制確保加算;
    }

    /**
     * @return the 在宅復帰在宅療養支援機能加算
     */
    public RString get在宅復帰在宅療養支援機能加算() {
        return 在宅復帰在宅療養支援機能加算;
    }

    /**
     * @return the 生活機能向上グループ活動加算
     */
    public RString get生活機能向上グループ活動加算() {
        return 生活機能向上グループ活動加算;
    }

    /**
     * @return the 介護職員処遇改善加算
     */
    public RString get介護職員処遇改善加算() {
        return 介護職員処遇改善加算;
    }

    /**
     * @param 指定基準該当等事業所区分 the 指定基準該当等事業所区分 to set
     */
    public void set指定基準該当等事業所区分(RString 指定基準該当等事業所区分) {
        this.指定基準該当等事業所区分 = 指定基準該当等事業所区分;
    }

    /**
     * @param 指定番号 the 指定番号 to set
     */
    public void set指定番号(RString 指定番号) {
        this.指定番号 = 指定番号;
    }

    /**
     * @param 管理者氏名カナ the 管理者氏名カナ to set
     */
    public void set管理者氏名カナ(RString 管理者氏名カナ) {
        this.管理者氏名カナ = 管理者氏名カナ;
    }

    /**
     * @param 管理者氏名 the 管理者氏名 to set
     */
    public void set管理者氏名(RString 管理者氏名) {
        this.管理者氏名 = 管理者氏名;
    }

    /**
     * @param 管理者電話番号 the 管理者電話番号 to set
     */
    public void set管理者電話番号(RString 管理者電話番号) {
        this.管理者電話番号 = 管理者電話番号;
    }

    /**
     * @param 管理者住所郵便番号 the 管理者住所郵便番号 to set
     */
    public void set管理者住所郵便番号(RString 管理者住所郵便番号) {
        this.管理者住所郵便番号 = 管理者住所郵便番号;
    }

    /**
     * @param 管理者住所カナ the 管理者住所カナ to set
     */
    public void set管理者住所カナ(RString 管理者住所カナ) {
        this.管理者住所カナ = 管理者住所カナ;
    }

    /**
     * @param 管理者住所 the 管理者住所 to set
     */
    public void set管理者住所(RString 管理者住所) {
        this.管理者住所 = 管理者住所;
    }

    /**
     * @param 事業開始年月日 the 事業開始年月日 to set
     */
    public void set事業開始年月日(RDate 事業開始年月日) {
        this.事業開始年月日 = 事業開始年月日;
    }

    /**
     * @param 事業休止年月日 the 事業休止年月日 to set
     */
    public void set事業休止年月日(RDate 事業休止年月日) {
        this.事業休止年月日 = 事業休止年月日;
    }

    /**
     * @param 事業廃止年月日 the 事業廃止年月日 to set
     */
    public void set事業廃止年月日(RDate 事業廃止年月日) {
        this.事業廃止年月日 = 事業廃止年月日;
    }

    /**
     * @param 事業再開年月日 the 事業再開年月日 to set
     */
    public void set事業再開年月日(RDate 事業再開年月日) {
        this.事業再開年月日 = 事業再開年月日;
    }

    /**
     * @param 施設等の区分 the 施設等の区分 to set
     */
    public void set施設等の区分(RString 施設等の区分) {
        this.施設等の区分 = 施設等の区分;
    }

    /**
     * @param 人員配置区分 the 人員配置区分 to set
     */
    public void set人員配置区分(RString 人員配置区分) {
        this.人員配置区分 = 人員配置区分;
    }

    /**
     * @param 機能訓練指導体制の有無 the 機能訓練指導体制の有無 to set
     */
    public void set機能訓練指導体制の有無(Boolean 機能訓練指導体制の有無) {
        this.機能訓練指導体制の有無 = 機能訓練指導体制の有無;
    }

    /**
     * @param 食事提供体制の有無 the 食事提供体制の有無 to set
     */
    public void set食事提供体制の有無(Boolean 食事提供体制の有無) {
        this.食事提供体制の有無 = 食事提供体制の有無;
    }

    /**
     * @param 入浴介助体制の有無 the 入浴介助体制の有無 to set
     */
    public void set入浴介助体制の有無(Boolean 入浴介助体制の有無) {
        this.入浴介助体制の有無 = 入浴介助体制の有無;
    }

    /**
     * @param 特別入浴介助体制の有無 the 特別入浴介助体制の有無 to set
     */
    public void set特別入浴介助体制の有無(Boolean 特別入浴介助体制の有無) {
        this.特別入浴介助体制の有無 = 特別入浴介助体制の有無;
    }

    /**
     * @param 常勤専従医師配置の有無 the 常勤専従医師配置の有無 to set
     */
    public void set常勤専従医師配置の有無(Boolean 常勤専従医師配置の有無) {
        this.常勤専従医師配置の有無 = 常勤専従医師配置の有無;
    }

    /**
     * @param 医師の配置基準 the 医師の配置基準 to set
     */
    public void set医師の配置基準(RString 医師の配置基準) {
        this.医師の配置基準 = 医師の配置基準;
    }

    /**
     * @param 精神科医師定期的療養指導の有無 the 精神科医師定期的療養指導の有無 to set
     */
    public void set精神科医師定期的療養指導の有無(Boolean 精神科医師定期的療養指導の有無) {
        this.精神科医師定期的療養指導の有無 = 精神科医師定期的療養指導の有無;
    }

    /**
     * @param 夜間勤務条件基準 the 夜間勤務条件基準 to set
     */
    public void set夜間勤務条件基準(RString 夜間勤務条件基準) {
        this.夜間勤務条件基準 = 夜間勤務条件基準;
    }

    /**
     * @param 認知症専門棟の有無 the 認知症専門棟の有無 to set
     */
    public void set認知症専門棟の有無(Boolean 認知症専門棟の有無) {
        this.認知症専門棟の有無 = 認知症専門棟の有無;
    }

    /**
     * @param 食事提供の状況 the 食事提供の状況 to set
     */
    public void set食事提供の状況(RString 食事提供の状況) {
        this.食事提供の状況 = 食事提供の状況;
    }

    /**
     * @param 送迎体制 the 送迎体制 to set
     */
    public void set送迎体制(RString 送迎体制) {
        this.送迎体制 = 送迎体制;
    }

    /**
     * @param リハビリテーション提供体制総合リハビリテーション施設の有無 the リハビリテーション提供体制総合リハビリテーション施設の有無 to
     * set
     */
    public void setリハビリテーション提供体制総合リハビリテーション施設の有無(Boolean リハビリテーション提供体制総合リハビリテーション施設の有無) {
        this.リハビリテーション提供体制総合リハビリテーション施設の有無 = リハビリテーション提供体制総合リハビリテーション施設の有無;
    }

    /**
     * @param リハビリテーション提供体制理学療法Ⅱの有無 the リハビリテーション提供体制理学療法Ⅱの有無 to set
     */
    public void setリハビリテーション提供体制理学療法Ⅱの有無(Boolean リハビリテーション提供体制理学療法Ⅱの有無) {
        this.リハビリテーション提供体制理学療法Ⅱの有無 = リハビリテーション提供体制理学療法Ⅱの有無;
    }

    /**
     * @param リハビリテーション提供体制理学療法Ⅲの有無 the リハビリテーション提供体制理学療法Ⅲの有無 to set
     */
    public void setリハビリテーション提供体制理学療法Ⅲの有無(Boolean リハビリテーション提供体制理学療法Ⅲの有無) {
        this.リハビリテーション提供体制理学療法Ⅲの有無 = リハビリテーション提供体制理学療法Ⅲの有無;
    }

    /**
     * @param リハビリテーション提供体制作業療法Ⅱの有無 the リハビリテーション提供体制作業療法Ⅱの有無 to set
     */
    public void setリハビリテーション提供体制作業療法Ⅱの有無(Boolean リハビリテーション提供体制作業療法Ⅱの有無) {
        this.リハビリテーション提供体制作業療法Ⅱの有無 = リハビリテーション提供体制作業療法Ⅱの有無;
    }

    /**
     * @param リハビリテーション提供体制精神科作業療法の有無 the リハビリテーション提供体制精神科作業療法の有無 to set
     */
    public void setリハビリテーション提供体制精神科作業療法の有無(Boolean リハビリテーション提供体制精神科作業療法の有無) {
        this.リハビリテーション提供体制精神科作業療法の有無 = リハビリテーション提供体制精神科作業療法の有無;
    }

    /**
     * @param リハビリテーション提供体制その他の有無 the リハビリテーション提供体制その他の有無 to set
     */
    public void setリハビリテーション提供体制その他の有無(Boolean リハビリテーション提供体制その他の有無) {
        this.リハビリテーション提供体制その他の有無 = リハビリテーション提供体制その他の有無;
    }

    /**
     * @param リハビリテーションの加算状況の有無 the リハビリテーションの加算状況の有無 to set
     */
    public void setリハビリテーションの加算状況の有無(Boolean リハビリテーションの加算状況の有無) {
        this.リハビリテーションの加算状況の有無 = リハビリテーションの加算状況の有無;
    }

    /**
     * @param 療養環境基準 the 療養環境基準 to set
     */
    public void set療養環境基準(RString 療養環境基準) {
        this.療養環境基準 = 療養環境基準;
    }

    /**
     * @param 医師の欠員による減算の状況の有無 the 医師の欠員による減算の状況の有無 to set
     */
    public void set医師の欠員による減算の状況の有無(Boolean 医師の欠員による減算の状況の有無) {
        this.医師の欠員による減算の状況の有無 = 医師の欠員による減算の状況の有無;
    }

    /**
     * @param 看護職員の欠員による減算の状況の有無 the 看護職員の欠員による減算の状況の有無 to set
     */
    public void set看護職員の欠員による減算の状況の有無(Boolean 看護職員の欠員による減算の状況の有無) {
        this.看護職員の欠員による減算の状況の有無 = 看護職員の欠員による減算の状況の有無;
    }

    /**
     * @param 理学療法士の欠員による減算の状況の有無 the 理学療法士の欠員による減算の状況の有無 to set
     */
    public void set理学療法士の欠員による減算の状況の有無(Boolean 理学療法士の欠員による減算の状況の有無) {
        this.理学療法士の欠員による減算の状況の有無 = 理学療法士の欠員による減算の状況の有無;
    }

    /**
     * @param 作業療法士の欠員による減算の状況の有無 the 作業療法士の欠員による減算の状況の有無 to set
     */
    public void set作業療法士の欠員による減算の状況の有無(Boolean 作業療法士の欠員による減算の状況の有無) {
        this.作業療法士の欠員による減算の状況の有無 = 作業療法士の欠員による減算の状況の有無;
    }

    /**
     * @param 介護職員の欠員による減算の状況の有無 the 介護職員の欠員による減算の状況の有無 to set
     */
    public void set介護職員の欠員による減算の状況の有無(Boolean 介護職員の欠員による減算の状況の有無) {
        this.介護職員の欠員による減算の状況の有無 = 介護職員の欠員による減算の状況の有無;
    }

    /**
     * @param 介護支援専門員の欠員による減算の状況の有無 the 介護支援専門員の欠員による減算の状況の有無 to set
     */
    public void set介護支援専門員の欠員による減算の状況の有無(Boolean 介護支援専門員の欠員による減算の状況の有無) {
        this.介護支援専門員の欠員による減算の状況の有無 = 介護支援専門員の欠員による減算の状況の有無;
    }

    /**
     * @param 介護従業者の欠員による減算の状況の有無 the 介護従業者の欠員による減算の状況の有無 to set
     */
    public void set介護従業者の欠員による減算の状況の有無(Boolean 介護従業者の欠員による減算の状況の有無) {
        this.介護従業者の欠員による減算の状況の有無 = 介護従業者の欠員による減算の状況の有無;
    }

    /**
     * @param 感染対策指導管理の有無 the 感染対策指導管理の有無 to set
     */
    public void set感染対策指導管理の有無(Boolean 感染対策指導管理の有無) {
        this.感染対策指導管理の有無 = 感染対策指導管理の有無;
    }

    /**
     * @param 重症皮膚潰瘍指導管理の有無 the 重症皮膚潰瘍指導管理の有無 to set
     */
    public void set重症皮膚潰瘍指導管理の有無(Boolean 重症皮膚潰瘍指導管理の有無) {
        this.重症皮膚潰瘍指導管理の有無 = 重症皮膚潰瘍指導管理の有無;
    }

    /**
     * @param 薬剤管理指導の有無 the 薬剤管理指導の有無 to set
     */
    public void set薬剤管理指導の有無(Boolean 薬剤管理指導の有無) {
        this.薬剤管理指導の有無 = 薬剤管理指導の有無;
    }

    /**
     * @param 障害者生活支援体制の有無 the 障害者生活支援体制の有無 to set
     */
    public void set障害者生活支援体制の有無(Boolean 障害者生活支援体制の有無) {
        this.障害者生活支援体制の有無 = 障害者生活支援体制の有無;
    }

    /**
     * @param 生活保護法による指定の有無 the 生活保護法による指定の有無 to set
     */
    public void set生活保護法による指定の有無(Boolean 生活保護法による指定の有無) {
        this.生活保護法による指定の有無 = 生活保護法による指定の有無;
    }

    /**
     * @param 地域区分コード the 地域区分コード to set
     */
    public void set地域区分コード(RString 地域区分コード) {
        this.地域区分コード = 地域区分コード;
    }

    /**
     * @param 登録保険者番号 the 登録保険者番号 to set
     */
    public void set登録保険者番号(RString 登録保険者番号) {
        this.登録保険者番号 = 登録保険者番号;
    }

    /**
     * @param 受領委任の有無 the 受領委任の有無 to set
     */
    public void set受領委任の有無(Boolean 受領委任の有無) {
        this.受領委任の有無 = 受領委任の有無;
    }

    /**
     * @param 登録開始年月日 the 登録開始年月日 to set
     */
    public void set登録開始年月日(RDate 登録開始年月日) {
        this.登録開始年月日 = 登録開始年月日;
    }

    /**
     * @param 登録終了年月日 the 登録終了年月日 to set
     */
    public void set登録終了年月日(RDate 登録終了年月日) {
        this.登録終了年月日 = 登録終了年月日;
    }

    /**
     * @param 時間延長サービス体制 the 時間延長サービス体制 to set
     */
    public void set時間延長サービス体制(RString 時間延長サービス体制) {
        this.時間延長サービス体制 = 時間延長サービス体制;
    }

    /**
     * @param 個別リハビリテーション提供体制 the 個別リハビリテーション提供体制 to set
     */
    public void set個別リハビリテーション提供体制(RString 個別リハビリテーション提供体制) {
        this.個別リハビリテーション提供体制 = 個別リハビリテーション提供体制;
    }

    /**
     * @param 居住費対策 the 居住費対策 to set
     */
    public void set居住費対策(RString 居住費対策) {
        this.居住費対策 = 居住費対策;
    }

    /**
     * @param 夜間ケアの有無 the 夜間ケアの有無 to set
     */
    public void set夜間ケアの有無(Boolean 夜間ケアの有無) {
        this.夜間ケアの有無 = 夜間ケアの有無;
    }

    /**
     * @param リハビリテーション機能強化の有無 the リハビリテーション機能強化の有無 to set
     */
    public void setリハビリテーション機能強化の有無(Boolean リハビリテーション機能強化の有無) {
        this.リハビリテーション機能強化の有無 = リハビリテーション機能強化の有無;
    }

    /**
     * @param 個別リハビリテーション提供体制総合リハビリテーション施設の有無 the
     * 個別リハビリテーション提供体制総合リハビリテーション施設の有無 to set
     */
    public void set個別リハビリテーション提供体制総合リハビリテーション施設の有無(Boolean 個別リハビリテーション提供体制総合リハビリテーション施設の有無) {
        this.個別リハビリ提供体制総合リハビリテーション施設の有無 = 個別リハビリテーション提供体制総合リハビリテーション施設の有無;
    }

    /**
     * @param 個別リハビリテーション提供体制理学療法Ⅱの有無1 the 個別リハビリテーション提供体制理学療法Ⅱの有無1 to set
     */
    public void set個別リハビリテーション提供体制理学療法Ⅱの有無1(Boolean 個別リハビリテーション提供体制理学療法Ⅱの有無1) {
        this.個別リハビリテーション提供体制理学療法Ⅱの有無1 = 個別リハビリテーション提供体制理学療法Ⅱの有無1;
    }

    /**
     * @param 個別リハビリテーション提供体制理学療法Ⅲの有無 the 個別リハビリテーション提供体制理学療法Ⅲの有無 to set
     */
    public void set個別リハビリテーション提供体制理学療法Ⅲの有無(Boolean 個別リハビリテーション提供体制理学療法Ⅲの有無) {
        this.個別リハビリテーション提供体制理学療法Ⅲの有無 = 個別リハビリテーション提供体制理学療法Ⅲの有無;
    }

    /**
     * @param 個別リハビリテーション提供体制作業療法Ⅱの有無 the 個別リハビリテーション提供体制作業療法Ⅱの有無 to set
     */
    public void set個別リハビリテーション提供体制作業療法Ⅱの有無(Boolean 個別リハビリテーション提供体制作業療法Ⅱの有無) {
        this.個別リハビリテーション提供体制作業療法Ⅱの有無 = 個別リハビリテーション提供体制作業療法Ⅱの有無;
    }

    /**
     * @param 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無 the 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無 to set
     */
    public void set個別リハビリテーション提供体制言語聴覚療法Ⅰの有無(Boolean 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無) {
        this.個別リハビリテーション提供体制言語聴覚療法Ⅰの有無 = 個別リハビリテーション提供体制言語聴覚療法Ⅰの有無;
    }

    /**
     * @param 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無 the 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無 to set
     */
    public void set個別リハビリテーション提供体制言語聴覚療法Ⅱの有無(Boolean 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無) {
        this.個別リハビリテーション提供体制言語聴覚療法Ⅱの有無 = 個別リハビリテーション提供体制言語聴覚療法Ⅱの有無;
    }

    /**
     * @param 言語聴覚士の欠員による減算の状況の有無 the 言語聴覚士の欠員による減算の状況の有無 to set
     */
    public void set言語聴覚士の欠員による減算の状況の有無(Boolean 言語聴覚士の欠員による減算の状況の有無) {
        this.言語聴覚士の欠員による減算の状況の有無 = 言語聴覚士の欠員による減算の状況の有無;
    }

    /**
     * @param 栄養管理の評価 the 栄養管理の評価 to set
     */
    public void set栄養管理の評価(RString 栄養管理の評価) {
        this.栄養管理の評価 = 栄養管理の評価;
    }

    /**
     * @param 社会福祉法人軽減事業実施の有無 the 社会福祉法人軽減事業実施の有無 to set
     */
    public void set社会福祉法人軽減事業実施の有無(Boolean 社会福祉法人軽減事業実施の有無) {
        this.社会福祉法人軽減事業実施の有無 = 社会福祉法人軽減事業実施の有無;
    }

    /**
     * @param 特定事業所加算訪問介護の有無 the 特定事業所加算訪問介護の有無 to set
     */
    public void set特定事業所加算訪問介護の有無(Boolean 特定事業所加算訪問介護の有無) {
        this.特定事業所加算訪問介護の有無 = 特定事業所加算訪問介護の有無;
    }

    /**
     * @param 若年性認知症ケア体制の有無 the 若年性認知症ケア体制の有無 to set
     */
    public void set若年性認知症ケア体制の有無(Boolean 若年性認知症ケア体制の有無) {
        this.若年性認知症ケア体制の有無 = 若年性認知症ケア体制の有無;
    }

    /**
     * @param 運動器機能向上体制の有無 the 運動器機能向上体制の有無 to set
     */
    public void set運動器機能向上体制の有無(Boolean 運動器機能向上体制の有無) {
        this.運動器機能向上体制の有無 = 運動器機能向上体制の有無;
    }

    /**
     * @param 栄養マネジメント改善体制の有無 the 栄養マネジメント改善体制の有無 to set
     */
    public void set栄養マネジメント改善体制の有無(Boolean 栄養マネジメント改善体制の有無) {
        this.栄養マネジメント改善体制の有無 = 栄養マネジメント改善体制の有無;
    }

    /**
     * @param 口腔機能向上体制の有無 the 口腔機能向上体制の有無 to set
     */
    public void set口腔機能向上体制の有無(Boolean 口腔機能向上体制の有無) {
        this.口腔機能向上体制の有無 = 口腔機能向上体制の有無;
    }

    /**
     * @param 事業所評価加算申出の有無 the 事業所評価加算申出の有無 to set
     */
    public void set事業所評価加算申出の有無(Boolean 事業所評価加算申出の有無) {
        this.事業所評価加算申出の有無 = 事業所評価加算申出の有無;
    }

    /**
     * @param 事業所評価加算決定の有無 the 事業所評価加算決定の有無 to set
     */
    public void set事業所評価加算決定の有無(Boolean 事業所評価加算決定の有無) {
        this.事業所評価加算決定の有無 = 事業所評価加算決定の有無;
    }

    /**
     * @param 緊急受入体制の有無 the 緊急受入体制の有無 to set
     */
    public void set緊急受入体制の有無(Boolean 緊急受入体制の有無) {
        this.緊急受入体制の有無 = 緊急受入体制の有無;
    }

    /**
     * @param 夜間看護体制の有無 the 夜間看護体制の有無 to set
     */
    public void set夜間看護体制の有無(Boolean 夜間看護体制の有無) {
        this.夜間看護体制の有無 = 夜間看護体制の有無;
    }

    /**
     * @param 特定事業所加算居宅介護支援の有無 the 特定事業所加算居宅介護支援の有無 to set
     */
    public void set特定事業所加算居宅介護支援の有無(Boolean 特定事業所加算居宅介護支援の有無) {
        this.特定事業所加算居宅介護支援の有無 = 特定事業所加算居宅介護支援の有無;
    }

    /**
     * @param 介護支援専門員数専従の常勤者 the 介護支援専門員数専従の常勤者 to set
     */
    public void set介護支援専門員数専従の常勤者(Integer 介護支援専門員数専従の常勤者) {
        this.介護支援専門員数専従の常勤者 = 介護支援専門員数専従の常勤者;
    }

    /**
     * @param 介護支援専門員数専従の非常勤者 the 介護支援専門員数専従の非常勤者 to set
     */
    public void set介護支援専門員数専従の非常勤者(Integer 介護支援専門員数専従の非常勤者) {
        this.介護支援専門員数専従の非常勤者 = 介護支援専門員数専従の非常勤者;
    }

    /**
     * @param 介護支援専門員数兼務の常勤者 the 介護支援専門員数兼務の常勤者 to set
     */
    public void set介護支援専門員数兼務の常勤者(Integer 介護支援専門員数兼務の常勤者) {
        this.介護支援専門員数兼務の常勤者 = 介護支援専門員数兼務の常勤者;
    }

    /**
     * @param 介護支援専門員数兼務の非常勤者 the 介護支援専門員数兼務の非常勤者 to set
     */
    public void set介護支援専門員数兼務の非常勤者(Integer 介護支援専門員数兼務の非常勤者) {
        this.介護支援専門員数兼務の非常勤者 = 介護支援専門員数兼務の非常勤者;
    }

    /**
     * @param 訪問介護サービス提供責任者数 the 訪問介護サービス提供責任者数 to set
     */
    public void set訪問介護サービス提供責任者数(Integer 訪問介護サービス提供責任者数) {
        this.訪問介護サービス提供責任者数 = 訪問介護サービス提供責任者数;
    }

    /**
     * @param 訪問介護員数専従の常勤者 the 訪問介護員数専従の常勤者 to set
     */
    public void set訪問介護員数専従の常勤者(Integer 訪問介護員数専従の常勤者) {
        this.訪問介護員数専従の常勤者 = 訪問介護員数専従の常勤者;
    }

    /**
     * @param 訪問介護員数専従の非常勤者 the 訪問介護員数専従の非常勤者 to set
     */
    public void set訪問介護員数専従の非常勤者(Integer 訪問介護員数専従の非常勤者) {
        this.訪問介護員数専従の非常勤者 = 訪問介護員数専従の非常勤者;
    }

    /**
     * @param 訪問介護員数兼務の常勤者 the 訪問介護員数兼務の常勤者 to set
     */
    public void set訪問介護員数兼務の常勤者(Integer 訪問介護員数兼務の常勤者) {
        this.訪問介護員数兼務の常勤者 = 訪問介護員数兼務の常勤者;
    }

    /**
     * @param 訪問介護員数兼務の非常勤者 the 訪問介護員数兼務の非常勤者 to set
     */
    public void set訪問介護員数兼務の非常勤者(Integer 訪問介護員数兼務の非常勤者) {
        this.訪問介護員数兼務の非常勤者 = 訪問介護員数兼務の非常勤者;
    }

    /**
     * @param 訪問介護員数常勤換算後の人数 the 訪問介護員数常勤換算後の人数 to set
     */
    public void set訪問介護員数常勤換算後の人数(Integer 訪問介護員数常勤換算後の人数) {
        this.訪問介護員数常勤換算後の人数 = 訪問介護員数常勤換算後の人数;
    }

    /**
     * @param 利用定員数 the 利用定員数 to set
     */
    public void set利用定員数(Integer 利用定員数) {
        this.利用定員数 = 利用定員数;
    }

    /**
     * @param 指定更新申請中区分 the 指定更新申請中区分 to set
     */
    public void set指定更新申請中区分(RString 指定更新申請中区分) {
        this.指定更新申請中区分 = 指定更新申請中区分;
    }

    /**
     * @param 効力停止開始年月日 the 効力停止開始年月日 to set
     */
    public void set効力停止開始年月日(RDate 効力停止開始年月日) {
        this.効力停止開始年月日 = 効力停止開始年月日;
    }

    /**
     * @param 効力停止終了年月日 the 効力停止終了年月日 to set
     */
    public void set効力停止終了年月日(RDate 効力停止終了年月日) {
        this.効力停止終了年月日 = 効力停止終了年月日;
    }

    /**
     * @param 大規模事業所該当の有無 the 大規模事業所該当の有無 to set
     */
    public void set大規模事業所該当の有無(Boolean 大規模事業所該当の有無) {
        this.大規模事業所該当の有無 = 大規模事業所該当の有無;
    }

    /**
     * @param 準ユニットケア体制の有無 the 準ユニットケア体制の有無 to set
     */
    public void set準ユニットケア体制の有無(Boolean 準ユニットケア体制の有無) {
        this.準ユニットケア体制の有無 = 準ユニットケア体制の有無;
    }

    /**
     * @param 重度化対応体制の有無 the 重度化対応体制の有無 to set
     */
    public void set重度化対応体制の有無(Boolean 重度化対応体制の有無) {
        this.重度化対応体制の有無 = 重度化対応体制の有無;
    }

    /**
     * @param 医療連携体制の有無 the 医療連携体制の有無 to set
     */
    public void set医療連携体制の有無(Boolean 医療連携体制の有無) {
        this.医療連携体制の有無 = 医療連携体制の有無;
    }

    /**
     * @param ユニットケア体制の有無 the ユニットケア体制の有無 to set
     */
    public void setユニットケア体制の有無(Boolean ユニットケア体制の有無) {
        this.ユニットケア体制の有無 = ユニットケア体制の有無;
    }

    /**
     * @param 在宅入所相互利用体制の有無 the 在宅入所相互利用体制の有無 to set
     */
    public void set在宅入所相互利用体制の有無(Boolean 在宅入所相互利用体制の有無) {
        this.在宅入所相互利用体制の有無 = 在宅入所相互利用体制の有無;
    }

    /**
     * @param ターミナルケア体制看取り介護体制の有無 the ターミナルケア体制看取り介護体制の有無 to set
     */
    public void setターミナルケア体制看取り介護体制の有無(Boolean ターミナルケア体制看取り介護体制の有無) {
        this.ターミナルケア体制看取り介護体制の有無 = ターミナルケア体制看取り介護体制の有無;
    }

    /**
     * @param 身体拘束廃止取組の有無 the 身体拘束廃止取組の有無 to set
     */
    public void set身体拘束廃止取組の有無(Boolean 身体拘束廃止取組の有無) {
        this.身体拘束廃止取組の有無 = 身体拘束廃止取組の有無;
    }

    /**
     * @param 小規模拠点集合体制の有無 the 小規模拠点集合体制の有無 to set
     */
    public void set小規模拠点集合体制の有無(Boolean 小規模拠点集合体制の有無) {
        this.小規模拠点集合体制の有無 = 小規模拠点集合体制の有無;
    }

    /**
     * @param 認知症ケア加算の有無 the 認知症ケア加算の有無 to set
     */
    public void set認知症ケア加算の有無(Boolean 認知症ケア加算の有無) {
        this.認知症ケア加算の有無 = 認知症ケア加算の有無;
    }

    /**
     * @param 個別機能訓練体制の有無 the 個別機能訓練体制の有無 to set
     */
    public void set個別機能訓練体制の有無(Boolean 個別機能訓練体制の有無) {
        this.個別機能訓練体制の有無 = 個別機能訓練体制の有無;
    }

    /**
     * @param 個別リハビリテーション提供体制理学療法Ⅰの有無 the 個別リハビリテーション提供体制理学療法Ⅰの有無 to set
     */
    public void set個別リハビリテーション提供体制理学療法Ⅰの有無(Boolean 個別リハビリテーション提供体制理学療法Ⅰの有無) {
        this.個別リハビリテーション提供体制理学療法Ⅰの有無 = 個別リハビリテーション提供体制理学療法Ⅰの有無;
    }

    /**
     * @param 個別リハビリテーション提供体制理学療法Ⅱの有無2 the 個別リハビリテーション提供体制理学療法Ⅱの有無2 to set
     */
    public void set個別リハビリテーション提供体制理学療法Ⅱの有無2(Boolean 個別リハビリテーション提供体制理学療法Ⅱの有無2) {
        this.個別リハビリテーション提供体制理学療法Ⅱの有無2 = 個別リハビリテーション提供体制理学療法Ⅱの有無2;
    }

    /**
     * @param 個別リハビリテーション提供体制作業療法の有無 the 個別リハビリテーション提供体制作業療法の有無 to set
     */
    public void set個別リハビリテーション提供体制作業療法の有無(Boolean 個別リハビリテーション提供体制作業療法の有無) {
        this.個別リハビリテーション提供体制作業療法の有無 = 個別リハビリテーション提供体制作業療法の有無;
    }

    /**
     * @param 個別リハビリテーション提供体制言語聴覚療法の有無 the 個別リハビリテーション提供体制言語聴覚療法の有無 to set
     */
    public void set個別リハビリテーション提供体制言語聴覚療法の有無(Boolean 個別リハビリテーション提供体制言語聴覚療法の有無) {
        this.個別リハビリテーション提供体制言語聴覚療法の有無 = 個別リハビリテーション提供体制言語聴覚療法の有無;
    }

    /**
     * @param 個別リハビリテーション提供体制その他の有無 the 個別リハビリテーション提供体制その他の有無 to set
     */
    public void set個別リハビリテーション提供体制その他の有無(Boolean 個別リハビリテーション提供体制その他の有無) {
        this.個別リハビリテーション提供体制その他の有無 = 個別リハビリテーション提供体制その他の有無;
    }

    /**
     * @param 設備基準 the 設備基準 to set
     */
    public void set設備基準(RString 設備基準) {
        this.設備基準 = 設備基準;
    }

    /**
     * @param 療養体制維持特別加算 the 療養体制維持特別加算 to set
     */
    public void set療養体制維持特別加算(RString 療養体制維持特別加算) {
        this.療養体制維持特別加算 = 療養体制維持特別加算;
    }

    /**
     * @param 個別リハビリテーション提供体制リハビリテーション指導管理の有無 the
     * 個別リハビリテーション提供体制リハビリテーション指導管理の有無 to set
     */
    public void set個別リハビリテーション提供体制リハビリテーション指導管理の有無(Boolean 個別リハビリテーション提供体制リハビリテーション指導管理の有無) {
        this.個別リハビリ提供体制リハビリテーション指導管理の有無 = 個別リハビリテーション提供体制リハビリテーション指導管理の有無;
    }

    /**
     * @param 三級ヘルパー体制 the 三級ヘルパー体制 to set
     */
    public void set三級ヘルパー体制(RString 三級ヘルパー体制) {
        this.三級ヘルパー体制 = 三級ヘルパー体制;
    }

    /**
     * @param 中山間地域等における小規模事業所加算地域に関する状況 the 中山間地域等における小規模事業所加算地域に関する状況 to set
     */
    public void set中山間地域等における小規模事業所加算地域に関する状況(RString 中山間地域等における小規模事業所加算地域に関する状況) {
        this.中山間地域等における小規模事業所加算地域に関する状況 = 中山間地域等における小規模事業所加算地域に関する状況;
    }

    /**
     * @param 中山間地域等における小規模事業所加算規模に関する状況 the 中山間地域等における小規模事業所加算規模に関する状況 to set
     */
    public void set中山間地域等における小規模事業所加算規模に関する状況(RString 中山間地域等における小規模事業所加算規模に関する状況) {
        this.中山間地域等における小規模事業所加算規模に関する状況 = 中山間地域等における小規模事業所加算規模に関する状況;
    }

    /**
     * @param サービス提供体制強化加算 the サービス提供体制強化加算 to set
     */
    public void setサービス提供体制強化加算(RString サービス提供体制強化加算) {
        this.サービス提供体制強化加算 = サービス提供体制強化加算;
    }

    /**
     * @param 認知症短期集中リハビリテーション加算 the 認知症短期集中リハビリテーション加算 to set
     */
    public void set認知症短期集中リハビリテーション加算(RString 認知症短期集中リハビリテーション加算) {
        this.認知症短期集中リハビリテーション加算 = 認知症短期集中リハビリテーション加算;
    }

    /**
     * @param 若年性認知症利用者入所者患者受入加算 the 若年性認知症利用者入所者患者受入加算 to set
     */
    public void set若年性認知症利用者入所者患者受入加算(RString 若年性認知症利用者入所者患者受入加算) {
        this.若年性認知症利用者入所者患者受入加算 = 若年性認知症利用者入所者患者受入加算;
    }

    /**
     * @param 看護体制加算 the 看護体制加算 to set
     */
    public void set看護体制加算(RString 看護体制加算) {
        this.看護体制加算 = 看護体制加算;
    }

    /**
     * @param 夜勤職員配置加算 the 夜勤職員配置加算 to set
     */
    public void set夜勤職員配置加算(RString 夜勤職員配置加算) {
        this.夜勤職員配置加算 = 夜勤職員配置加算;
    }

    /**
     * @param 療養食加算 the 療養食加算 to set
     */
    public void set療養食加算(RString 療養食加算) {
        this.療養食加算 = 療養食加算;
    }

    /**
     * @param 日常生活継続支援加算 the 日常生活継続支援加算 to set
     */
    public void set日常生活継続支援加算(RString 日常生活継続支援加算) {
        this.日常生活継続支援加算 = 日常生活継続支援加算;
    }

    /**
     * @param 認知症専門ケア加算 the 認知症専門ケア加算 to set
     */
    public void set認知症専門ケア加算(RString 認知症専門ケア加算) {
        this.認知症専門ケア加算 = 認知症専門ケア加算;
    }

    /**
     * @param 二十四時間通報対応加算 the 二十四時間通報対応加算 to set
     */
    public void set二十四時間通報対応加算(RString 二十四時間通報対応加算) {
        this.二十四時間通報対応加算 = 二十四時間通報対応加算;
    }

    /**
     * @param 看護職員配置加算 the 看護職員配置加算 to set
     */
    public void set看護職員配置加算(RString 看護職員配置加算) {
        this.看護職員配置加算 = 看護職員配置加算;
    }

    /**
     * @param 夜間ケア加算 the 夜間ケア加算 to set
     */
    public void set夜間ケア加算(RString 夜間ケア加算) {
        this.夜間ケア加算 = 夜間ケア加算;
    }

    /**
     * @param 集団コミュニケーション療法の有無 the 集団コミュニケーション療法の有無 to set
     */
    public void set集団コミュニケーション療法の有無(Boolean 集団コミュニケーション療法の有無) {
        this.集団コミュニケーション療法の有無 = 集団コミュニケーション療法の有無;
    }

    /**
     * @param サービス提供体制強化加算空床型 the サービス提供体制強化加算空床型 to set
     */
    public void setサービス提供体制強化加算空床型(RString サービス提供体制強化加算空床型) {
        this.サービス提供体制強化加算空床型 = サービス提供体制強化加算空床型;
    }

    /**
     * @param 日中の身体介護２０分未満体制の有無 the 日中の身体介護２０分未満体制の有無 to set
     */
    public void set日中の身体介護２０分未満体制の有無(Boolean 日中の身体介護２０分未満体制の有無) {
        this.日中の身体介護２０分未満体制の有無 = 日中の身体介護２０分未満体制の有無;
    }

    /**
     * @param サービス提供責任者体制の有無 the サービス提供責任者体制の有無 to set
     */
    public void setサービス提供責任者体制の有無(Boolean サービス提供責任者体制の有無) {
        this.サービス提供責任者体制の有無 = サービス提供責任者体制の有無;
    }

    /**
     * @param 同一建物に居住する利用者の減算の有無 the 同一建物に居住する利用者の減算の有無 to set
     */
    public void set同一建物に居住する利用者の減算の有無(Boolean 同一建物に居住する利用者の減算の有無) {
        this.同一建物に居住する利用者の減算の有無 = 同一建物に居住する利用者の減算の有無;
    }

    /**
     * @param 緊急短期入所体制確保加算 the 緊急短期入所体制確保加算 to set
     */
    public void set緊急短期入所体制確保加算(RString 緊急短期入所体制確保加算) {
        this.緊急短期入所体制確保加算 = 緊急短期入所体制確保加算;
    }

    /**
     * @param 在宅復帰在宅療養支援機能加算 the 在宅復帰在宅療養支援機能加算 to set
     */
    public void set在宅復帰在宅療養支援機能加算(RString 在宅復帰在宅療養支援機能加算) {
        this.在宅復帰在宅療養支援機能加算 = 在宅復帰在宅療養支援機能加算;
    }

    /**
     * @param 生活機能向上グループ活動加算 the 生活機能向上グループ活動加算 to set
     */
    public void set生活機能向上グループ活動加算(RString 生活機能向上グループ活動加算) {
        this.生活機能向上グループ活動加算 = 生活機能向上グループ活動加算;
    }

    /**
     * @param 介護職員処遇改善加算 the 介護職員処遇改善加算 to set
     */
    public void set介護職員処遇改善加算(RString 介護職員処遇改善加算) {
        this.介護職員処遇改善加算 = 介護職員処遇改善加算;
    }

    /**
     * @return the 事業者番号
     */
    public RString get事業者番号() {
        return 事業者番号;
    }

    /**
     * @param 事業者番号 the 事業者番号 to set
     */
    public void set事業者番号(RString 事業者番号) {
        this.事業者番号 = 事業者番号;
    }
}
