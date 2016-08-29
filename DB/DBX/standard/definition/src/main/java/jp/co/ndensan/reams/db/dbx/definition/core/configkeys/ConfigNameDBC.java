/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBC)を表す列挙型です。
 *
 * @reamsid_L DBX-9999-023 liangbc
 */
public enum ConfigNameDBC {

    /**
     * 国保連共同処理受託区分_事業高額
     */
    国保連共同処理受託区分_事業高額("国保連共同処理受託区分_事業高額"),
    /**
     * 国保連共同処理受託区分_高額
     */
    国保連共同処理受託区分_高額("国保連共同処理受託区分_高額"),
    /**
     * 初期表示_給付率。
     */
    初期表示_給付率("初期表示_償還支給申請登録初期"),
    /**
     * 償還支給申請書_審査方法初期表示。
     */
    償還支給申請書_審査方法初期表示("償還支給申請書_審査方法初期表示"),
    /**
     * 初期表示_償還支給申請登録初期。
     */
    初期表示_償還支給申請登録初期("初期表示_償還支給申請登録初期"),
    /**
     * 第1段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_201504以降_自己負担上限月額("第1段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第1段階_高額介護サービス費支給_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_自己負担上限月額("第1段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_201504以降_自己負担上限月額("第2段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_自己負担上限月額("第2段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_201504以降_自己負担上限月額("第3段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_自己負担上限月額("第3段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第4段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第4段階_高額介護サービス費支給_201504以降_自己負担上限月額("第4段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 国保連共同処理受託区分_償還
     */
    国保連共同処理受託区分_償還("国保連共同処理受託区分_償還"),
    /**
     * 国保連取込_取込ファイル_保管日数
     */
    国保連取込_取込ファイル_保管日数("国保連取込_取込ファイル_保管日数"),
    /**
     * 国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号("国保連取込_介護給付費過誤決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号("国保連取込_介護給付費過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_償還払支給決定者一覧情報_交換情報識別番号
     */
    国保連取込_償還払支給決定者一覧情報_交換情報識別番号("国保連取込_償還払支給決定者一覧情報_交換情報識別番号"),
    /**
     * 国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号
     */
    国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号(
            "国保連取込_高額介護サービス費給付対象者一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号
     */
    国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号(
            "国保連取込_高額介護サービス費支給不支給決定者一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号(
            "国保連取込_介護給付費再審査決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_受給者情報更新結果情報_交換情報識別番号
     */
    国保連取込_受給者情報更新結果情報_交換情報識別番号("国保連取込_受給者情報更新結果情報_交換情報識別番号"),
    /**
     * 国保連取込_共同処理用受給者情報更新結果_交換情報識別番号
     */
    国保連取込_共同処理用受給者情報更新結果_交換情報識別番号("国保連取込_共同処理用受給者情報更新結果_交換情報識別番号"),
    /**
     * 国保連取込_給付実績情報_交換情報識別番号
     */
    国保連取込_給付実績情報_交換情報識別番号("国保連取込_給付実績情報_交換情報識別番号"),
    /**
     * 国保連取込_給付管理票情報_交換情報識別番号
     */
    国保連取込_給付管理票情報_交換情報識別番号("国保連取込_給付管理票情報_交換情報識別番号"),
    /**
     * 国保連取込_給付実績更新結果情報_交換情報識別番号
     */
    国保連取込_給付実績更新結果情報_交換情報識別番号("国保連取込_給付実績更新結果情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号("国保連取込_介護給付費等審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号("国保連取込_介護給付費再審査決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等請求額通知書情報_交換情報識別番号
     */
    国保連取込_介護給付費等請求額通知書情報_交換情報識別番号("国保連取込_介護給付費等請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号
     */
    国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号("国保連取込_介護給付費等請求額通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号
     */
    国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号("国保連取込_介護給付費公費受給者別一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_償還払不支給決定者一覧情報_交換情報識別番号
     */
    国保連取込_償還払不支給決定者一覧情報_交換情報識別番号("国保連取込_償還払不支給決定者一覧情報_交換情報識別番号"),
    /**
     * 国保連取込_受給者台帳情報一覧_交換情報識別番号
     */
    国保連取込_受給者台帳情報一覧_交換情報識別番号("国保連取込_受給者台帳情報一覧_交換情報識別番号"),
    /**
     * 国保連取込_受給者台帳突合結果情報随時_交換情報識別番号
     */
    国保連取込_受給者台帳突合結果情報随時_交換情報識別番号("国保連取込_受給者台帳突合結果情報随時_交換情報識別番号"),
    /**
     * 国保連取込_共同処理用受給者情報一覧_交換情報識別番号
     */
    国保連取込_共同処理用受給者情報一覧_交換情報識別番号("国保連取込_共同処理用受給者情報一覧_交換情報識別番号"),
    /**
     * 国保連取込_高額合算自己負担額確認情報_交換情報識別番号
     */
    国保連取込_高額合算自己負担額確認情報_交換情報識別番号("国保連取込_高額合算自己負担額確認情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算自己負担額証明書情報_交換情報識別番号
     */
    国保連取込_高額合算自己負担額証明書情報_交換情報識別番号("国保連取込_高額合算自己負担額証明書情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号
     */
    国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号("国保連取込_高額合算支給額計算結果連絡票情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号
     */
    国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号("国保連取込_高額合算支給不支給決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_高額合算給付実績情報_交換情報識別番号
     */
    国保連取込_高額合算給付実績情報_交換情報識別番号("国保連取込_高額合算給付実績情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号(
            "国保連取込_総合事業費経過措置審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号
     */
    国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号(
            "国保連取込_請求明細給付管理票返戻保留一覧表情報_交換情報識別番号"),
    /**
     * 国保連取込_資格照合表情報_交換情報識別番号
     */
    国保連取込_資格照合表情報_交換情報識別番号("国保連取込_資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号
     */
    国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号("国保連取込_総合事業費経過措置資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号("国保連取込_総合事業費過誤決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号("国保連取込_総合事業費再審査決定通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号("国保連取込_総合事業費過誤決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号("国保連取込_総合事業費再審査決定通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費資格照合表情報_交換情報識別番号
     */
    国保連取込_総合事業費資格照合表情報_交換情報識別番号("国保連取込_総合事業費資格照合表情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費等請求額通知書情報_交換情報識別番号
     */
    国保連取込_総合事業費等請求額通知書情報_交換情報識別番号("国保連取込_総合事業費等請求額通知書情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号
     */
    国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号("国保連取込_総合事業費等請求額通知書公費情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号
     */
    国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号("国保連取込_総合事業費審査決定請求明細表情報_交換情報識別番号"),
    /**
     * 国保連送付_受給者異動連絡票情報_交換情報識別番号
     */
    国保連送付_受給者異動連絡票情報_交換情報識別番号("国保連送付_受給者異動連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_共同処理用受給者異動情報_交換情報識別番号
     */
    国保連送付_共同処理用受給者異動情報_交換情報識別番号("国保連送付_共同処理用受給者異動情報_交換情報識別番号"),
    /**
     * 国保連送付_給付管理票_交換情報識別番号
     */
    国保連送付_給付管理票_交換情報識別番号("国保連送付_給付管理票_交換情報識別番号"),
    /**
     * 国保連送付_償還連絡票情報_交換情報識別番号
     */
    国保連送付_償還連絡票情報_交換情報識別番号("国保連送付_償還連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号
     */
    国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号("国保連送付_高額介護サービス費給付判定結果情報_交換情報識別番号"),
    /**
     * 国保連送付_給付実績情報_交換情報識別番号
     */
    国保連送付_給付実績情報_交換情報識別番号("国保連送付_給付実績情報_交換情報識別番号"),
    /**
     * 国保連送付_過誤申立書情報_交換情報識別番号
     */
    国保連送付_過誤申立書情報_交換情報識別番号("国保連送付_過誤申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_再審査申立書情報_交換情報識別番号
     */
    国保連送付_再審査申立書情報_交換情報識別番号("国保連送付_再審査申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算支給申請書情報_交換情報識別番号
     */
    国保連送付_高額合算支給申請書情報_交換情報識別番号("国保連送付_高額合算支給申請書情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算補正済自己負担額情報_交換情報識別番号
     */
    国保連送付_高額合算補正済自己負担額情報_交換情報識別番号("国保連送付_高額合算補正済自己負担額情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算計算結果連絡票情報_交換情報識別番号
     */
    国保連送付_高額合算計算結果連絡票情報_交換情報識別番号("国保連送付_高額合算計算結果連絡票情報_交換情報識別番号"),
    /**
     * 国保連送付_高額合算給付実績情報_交換情報識別番号
     */
    国保連送付_高額合算給付実績情報_交換情報識別番号("国保連送付_高額合算給付実績情報_交換情報識別番号"),
    /**
     * 国保連送付_総合事業費過誤申立書情報_交換情報識別番号
     */
    国保連送付_総合事業費過誤申立書情報_交換情報識別番号("国保連送付_総合事業費過誤申立書情報_交換情報識別番号"),
    /**
     * 国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号
     */
    国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号("国保連送付_総合事業分サービスコード異動連絡票情報_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定Ｆ_交換情報識別番号("国保連取込媒体_過誤決定Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号("国保連取込媒体_過誤決定公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付管理Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付管理Ｆ_交換情報識別番号("国保連取込媒体_給付管理Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付実績Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付実績Ｆ_交換情報識別番号("国保連取込媒体_給付実績Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_給付実績結果Ｆ_交換情報識別番号("国保連取込媒体_給付実績結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_共同更新Ｆ_交換情報識別番号
     */
    国保連取込媒体_共同更新Ｆ_交換情報識別番号("国保連取込媒体_共同更新Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_共同受給Ｆ_交換情報識別番号
     */
    国保連取込媒体_共同受給Ｆ_交換情報識別番号("国保連取込媒体_共同受給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_交換情報識別番号
     */
    国保連取込媒体_公費一覧Ｆ_交換情報識別番号("国保連取込媒体_公費一覧Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_交換情報識別番号
     */
    国保連取込媒体_高額決定者Ｆ_交換情報識別番号("国保連取込媒体_高額決定者Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_交換情報識別番号
     */
    国保連取込媒体_高額対象者Ｆ_交換情報識別番号("国保連取込媒体_高額対象者Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_再審決定Ｆ_交換情報識別番号
     */
    国保連取込媒体_再審決定Ｆ_交換情報識別番号("国保連取込媒体_再審決定Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_再審決定公費Ｆ_交換情報識別番号("国保連取込媒体_再審決定公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給更新Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給更新Ｆ_交換情報識別番号("国保連取込媒体_受給更新Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給台帳Ｆ_交換情報識別番号("国保連取込媒体_受給台帳Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_受給突合結果Ｆ_交換情報識別番号("国保連取込媒体_受給突合結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_償還支給Ｆ_交換情報識別番号
     */
    国保連取込媒体_償還支給Ｆ_交換情報識別番号("国保連取込媒体_償還支給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_交換情報識別番号
     */
    国保連取込媒体_償還不支給Ｆ_交換情報識別番号("国保連取込媒体_償還不支給Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_審査請求Ｆ_交換情報識別番号
     */
    国保連取込媒体_審査請求Ｆ_交換情報識別番号("国保連取込媒体_審査請求Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知Ｆ_交換情報識別番号("国保連取込媒体_請求通知Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知公費Ｆ_交換情報識別番号("国保連取込媒体_請求通知公費Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_交換情報識別番号
     */
    国保連取込媒体_自己負担確認Ｆ_交換情報識別番号("国保連取込媒体_自己負担確認Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_交換情報識別番号
     */
    国保連取込媒体_自己負担証明Ｆ_交換情報識別番号("国保連取込媒体_自己負担証明Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_交換情報識別番号
     */
    国保連取込媒体_支給計算結果Ｆ_交換情報識別番号("国保連取込媒体_支給計算結果Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算支給通知Ｆ_交換情報識別番号("国保連取込媒体_合算支給通知Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号("国保連取込媒体_合算支給一覧Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_交換情報識別番号
     */
    国保連取込媒体_合算給付実績Ｆ_交換情報識別番号("国保連取込媒体_合算給付実績Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号("国保連取込媒体_過誤決定総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_請求通知総合Ｆ_交換情報識別番号("国保連取込媒体_請求通知総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_交換情報識別番号
     */
    国保連取込媒体_審査請求総合Ｆ_交換情報識別番号("国保連取込媒体_審査請求総合Ｆ_交換情報識別番号"),
    /**
     * 国保連取込_受給者情報突合結果情報_交換情報識別番号
     */
    国保連取込_受給者情報突合結果情報_交換情報識別番号("国保連取込_受給者情報突合結果情報_交換情報識別番号"),
    /**
     * 国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号
     */
    国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号("国保連取込_総合事業費公費受給者別一覧表_交換情報識別番号"),
    /**
     * 償還払支給不支給決定通知書一括作成_初期選択抽出条件
     */
    償還払支給不支給決定通知書一括作成_初期選択抽出条件("償還払支給不支給決定通知書一括作成_初期選択抽出条件"),
    /**
     * 利用者負担割合判定基準_本人未申告区分
     */
    利用者負担割合判定基準_本人未申告区分("利用者負担割合判定基準_本人未申告区分"),
    /**
     * 利用者負担割合判定基準_本人所得調査中区分
     */
    利用者負担割合判定基準_本人所得調査中区分("利用者負担割合判定基準_本人所得調査中区分"),
    /**
     * 利用者負担割合判定基準_本人合計所得金額基準
     */
    利用者負担割合判定基準_本人合計所得金額基準("利用者負担割合判定基準_本人合計所得金額基準"),
    /**
     * 利用者負担割合判定基準_世帯年金収入等基準単身
     */
    利用者負担割合判定基準_世帯年金収入等基準単身("利用者負担割合判定基準_世帯年金収入等基準単身"),
    /**
     * 利用者負担割合判定基準_世帯年金収入等基準複数
     */
    利用者負担割合判定基準_世帯年金収入等基準複数("利用者負担割合判定基準_世帯年金収入等基準複数"),
    /**
     * 利用者負担割合判定管理_年次負担割合処理済年度
     */
    利用者負担割合判定管理_年次負担割合処理済年度("利用者負担割合判定管理_年次負担割合処理済年度"),
    /**
     * 利用者負担割合判定管理_年次負担割合処理状態
     */
    利用者負担割合判定管理_年次負担割合処理状態("利用者負担割合判定管理_年次負担割合処理状態"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定Ｆ_ファイル名称("国保連取込媒体_過誤決定Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定公費Ｆ_ファイル名称("国保連取込媒体_過誤決定公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付管理Ｆ_ファイル名称
     */
    国保連取込媒体_給付管理Ｆ_ファイル名称("国保連取込媒体_給付管理Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付実績Ｆ_ファイル名称
     */
    国保連取込媒体_給付実績Ｆ_ファイル名称("国保連取込媒体_給付実績Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_ファイル名称
     */
    国保連取込媒体_給付実績結果Ｆ_ファイル名称("国保連取込媒体_給付実績結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_共同更新Ｆ_ファイル名称
     */
    国保連取込媒体_共同更新Ｆ_ファイル名称("国保連取込媒体_共同更新Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_共同受給Ｆ_ファイル名称
     */
    国保連取込媒体_共同受給Ｆ_ファイル名称("国保連取込媒体_共同受給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_ファイル名称
     */
    国保連取込媒体_公費一覧Ｆ_ファイル名称("国保連取込媒体_公費一覧Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_ファイル名称
     */
    国保連取込媒体_高額決定者Ｆ_ファイル名称("国保連取込媒体_高額決定者Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_ファイル名称
     */
    国保連取込媒体_高額対象者Ｆ_ファイル名称("国保連取込媒体_高額対象者Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_再審決定Ｆ_ファイル名称
     */
    国保連取込媒体_再審決定Ｆ_ファイル名称("国保連取込媒体_再審決定Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_ファイル名称
     */
    国保連取込媒体_再審決定公費Ｆ_ファイル名称("国保連取込媒体_再審決定公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給更新Ｆ_ファイル名称
     */
    国保連取込媒体_受給更新Ｆ_ファイル名称("国保連取込媒体_受給更新Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_ファイル名称
     */
    国保連取込媒体_受給台帳Ｆ_ファイル名称("国保連取込媒体_受給台帳Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_ファイル名称
     */
    国保連取込媒体_受給突合結果Ｆ_ファイル名称("国保連取込媒体_受給突合結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_償還支給Ｆ_ファイル名称
     */
    国保連取込媒体_償還支給Ｆ_ファイル名称("国保連取込媒体_償還支給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_ファイル名称
     */
    国保連取込媒体_償還不支給Ｆ_ファイル名称("国保連取込媒体_償還不支給Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_審査請求Ｆ_ファイル名称
     */
    国保連取込媒体_審査請求Ｆ_ファイル名称("国保連取込媒体_審査請求Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知Ｆ_ファイル名称("国保連取込媒体_請求通知Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知公費Ｆ_ファイル名称("国保連取込媒体_請求通知公費Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_ファイル名称
     */
    国保連取込媒体_自己負担確認Ｆ_ファイル名称("国保連取込媒体_自己負担確認Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_ファイル名称
     */
    国保連取込媒体_自己負担証明Ｆ_ファイル名称("国保連取込媒体_自己負担証明Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_ファイル名称
     */
    国保連取込媒体_支給計算結果Ｆ_ファイル名称("国保連取込媒体_支給計算結果Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_ファイル名称
     */
    国保連取込媒体_合算支給通知Ｆ_ファイル名称("国保連取込媒体_合算支給通知Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_ファイル名称
     */
    国保連取込媒体_合算支給一覧Ｆ_ファイル名称("国保連取込媒体_合算支給一覧Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_ファイル名称
     */
    国保連取込媒体_合算給付実績Ｆ_ファイル名称("国保連取込媒体_合算給付実績Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_ファイル名称
     */
    国保連取込媒体_過誤決定総合Ｆ_ファイル名称("国保連取込媒体_過誤決定総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_ファイル名称
     */
    国保連取込媒体_請求通知総合Ｆ_ファイル名称("国保連取込媒体_請求通知総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_ファイル名称
     */
    国保連取込媒体_審査請求総合Ｆ_ファイル名称("国保連取込媒体_審査請求総合Ｆ_ファイル名称"),
    /**
     * 国保連取込媒体_過誤決定Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定Ｆ_媒体区分("国保連取込媒体_過誤決定Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_過誤決定公費Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定公費Ｆ_媒体区分("国保連取込媒体_過誤決定公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付管理Ｆ_媒体区分
     */
    国保連取込媒体_給付管理Ｆ_媒体区分("国保連取込媒体_給付管理Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付実績Ｆ_媒体区分
     */
    国保連取込媒体_給付実績Ｆ_媒体区分("国保連取込媒体_給付実績Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_給付実績結果Ｆ_媒体区分
     */
    国保連取込媒体_給付実績結果Ｆ_媒体区分("国保連取込媒体_給付実績結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_共同更新Ｆ_媒体区分
     */
    国保連取込媒体_共同更新Ｆ_媒体区分("国保連取込媒体_共同更新Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_共同受給Ｆ_媒体区分
     */
    国保連取込媒体_共同受給Ｆ_媒体区分("国保連取込媒体_共同受給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_公費一覧Ｆ_媒体区分
     */
    国保連取込媒体_公費一覧Ｆ_媒体区分("国保連取込媒体_公費一覧Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_高額決定者Ｆ_媒体区分
     */
    国保連取込媒体_高額決定者Ｆ_媒体区分("国保連取込媒体_高額決定者Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_高額対象者Ｆ_媒体区分
     */
    国保連取込媒体_高額対象者Ｆ_媒体区分("国保連取込媒体_高額対象者Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_再審決定Ｆ_媒体区分
     */
    国保連取込媒体_再審決定Ｆ_媒体区分("国保連取込媒体_再審決定Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_再審決定公費Ｆ_媒体区分
     */
    国保連取込媒体_再審決定公費Ｆ_媒体区分("国保連取込媒体_再審決定公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給更新Ｆ_媒体区分
     */
    国保連取込媒体_受給更新Ｆ_媒体区分("国保連取込媒体_受給更新Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給台帳Ｆ_媒体区分
     */
    国保連取込媒体_受給台帳Ｆ_媒体区分("国保連取込媒体_受給台帳Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_受給突合結果Ｆ_媒体区分
     */
    国保連取込媒体_受給突合結果Ｆ_媒体区分("国保連取込媒体_受給突合結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_償還支給Ｆ_媒体区分
     */
    国保連取込媒体_償還支給Ｆ_媒体区分("国保連取込媒体_償還支給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_償還不支給Ｆ_媒体区分
     */
    国保連取込媒体_償還不支給Ｆ_媒体区分("国保連取込媒体_償還不支給Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_審査請求Ｆ_媒体区分
     */
    国保連取込媒体_審査請求Ｆ_媒体区分("国保連取込媒体_審査請求Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知Ｆ_媒体区分
     */
    国保連取込媒体_請求通知Ｆ_媒体区分("国保連取込媒体_請求通知Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知公費Ｆ_媒体区分
     */
    国保連取込媒体_請求通知公費Ｆ_媒体区分("国保連取込媒体_請求通知公費Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_自己負担確認Ｆ_媒体区分
     */
    国保連取込媒体_自己負担確認Ｆ_媒体区分("国保連取込媒体_自己負担確認Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_自己負担証明Ｆ_媒体区分
     */
    国保連取込媒体_自己負担証明Ｆ_媒体区分("国保連取込媒体_自己負担証明Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_支給計算結果Ｆ_媒体区分
     */
    国保連取込媒体_支給計算結果Ｆ_媒体区分("国保連取込媒体_支給計算結果Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算支給通知Ｆ_媒体区分
     */
    国保連取込媒体_合算支給通知Ｆ_媒体区分("国保連取込媒体_合算支給通知Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算支給一覧Ｆ_媒体区分
     */
    国保連取込媒体_合算支給一覧Ｆ_媒体区分("国保連取込媒体_合算支給一覧Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_合算給付実績Ｆ_媒体区分
     */
    国保連取込媒体_合算給付実績Ｆ_媒体区分("国保連取込媒体_合算給付実績Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_過誤決定総合Ｆ_媒体区分
     */
    国保連取込媒体_過誤決定総合Ｆ_媒体区分("国保連取込媒体_過誤決定総合Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_請求通知総合Ｆ_媒体区分
     */
    国保連取込媒体_請求通知総合Ｆ_媒体区分("国保連取込媒体_請求通知総合Ｆ_媒体区分"),
    /**
     * 国保連取込媒体_審査請求総合Ｆ_媒体区分
     */
    国保連取込媒体_審査請求総合Ｆ_媒体区分("国保連取込媒体_審査請求総合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_ファイル名称
     */
    国保連送付媒体_過誤申立Ｆ_ファイル名称("国保連送付媒体_過誤申立Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_ファイル名称
     */
    国保連送付媒体_給付管理票Ｆ_ファイル名称("国保連送付媒体_給付管理票Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_給付実績Ｆ_ファイル名称
     */
    国保連送付媒体_給付実績Ｆ_ファイル名称("国保連送付媒体_給付実績Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_共同異動Ｆ_ファイル名称
     */
    国保連送付媒体_共同異動Ｆ_ファイル名称("国保連送付媒体_共同異動Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_高額判定Ｆ_ファイル名称
     */
    国保連送付媒体_高額判定Ｆ_ファイル名称("国保連送付媒体_高額判定Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_再審申立Ｆ_ファイル名称
     */
    国保連送付媒体_再審申立Ｆ_ファイル名称("国保連送付媒体_再審申立Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給異動Ｆ_ファイル名称
     */
    国保連送付媒体_受給異動Ｆ_ファイル名称("国保連送付媒体_受給異動Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給突合Ｆ_ファイル名称
     */
    国保連送付媒体_受給突合Ｆ_ファイル名称("国保連送付媒体_受給突合Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_償還Ｆ_ファイル名称
     */
    国保連送付媒体_償還Ｆ_ファイル名称("国保連送付媒体_償還Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_支給申請Ｆ_ファイル名称
     */
    国保連送付媒体_支給申請Ｆ_ファイル名称("国保連送付媒体_支給申請Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_ファイル名称
     */
    国保連送付媒体_補正自己負担Ｆ_ファイル名称("国保連送付媒体_補正自己負担Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_ファイル名称
     */
    国保連送付媒体_計算結果連絡Ｆ_ファイル名称("国保連送付媒体_計算結果連絡Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_ファイル名称
     */
    国保連送付媒体_合算給付実績Ｆ_ファイル名称("国保連送付媒体_合算給付実績Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_ファイル名称
     */
    国保連送付媒体_過誤申立総合Ｆ_ファイル名称("国保連送付媒体_過誤申立総合Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_ファイル名称
     */
    国保連送付媒体_受給訂正Ｆ_ファイル名称("国保連送付媒体_受給訂正Ｆ_ファイル名称"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_媒体区分
     */
    国保連送付媒体_過誤申立Ｆ_媒体区分("国保連送付媒体_過誤申立Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_媒体区分
     */
    国保連送付媒体_給付管理票Ｆ_媒体区分("国保連送付媒体_給付管理票Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_給付実績Ｆ_媒体区分
     */
    国保連送付媒体_給付実績Ｆ_媒体区分("国保連送付媒体_給付実績Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_共同異動Ｆ_媒体区分
     */
    国保連送付媒体_共同異動Ｆ_媒体区分("国保連送付媒体_共同異動Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_高額判定Ｆ_媒体区分
     */
    国保連送付媒体_高額判定Ｆ_媒体区分("国保連送付媒体_高額判定Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_再審申立Ｆ_媒体区分
     */
    国保連送付媒体_再審申立Ｆ_媒体区分("国保連送付媒体_再審申立Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給異動Ｆ_媒体区分
     */
    国保連送付媒体_受給異動Ｆ_媒体区分("国保連送付媒体_受給異動Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給突合Ｆ_媒体区分
     */
    国保連送付媒体_受給突合Ｆ_媒体区分("国保連送付媒体_受給突合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_償還Ｆ_媒体区分
     */
    国保連送付媒体_償還Ｆ_媒体区分("国保連送付媒体_償還Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_支給申請Ｆ_媒体区分
     */
    国保連送付媒体_支給申請Ｆ_媒体区分("国保連送付媒体_支給申請Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_媒体区分
     */
    国保連送付媒体_補正自己負担Ｆ_媒体区分("国保連送付媒体_補正自己負担Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_媒体区分
     */
    国保連送付媒体_計算結果連絡Ｆ_媒体区分("国保連送付媒体_計算結果連絡Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_媒体区分
     */
    国保連送付媒体_合算給付実績Ｆ_媒体区分("国保連送付媒体_合算給付実績Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_媒体区分
     */
    国保連送付媒体_過誤申立総合Ｆ_媒体区分("国保連送付媒体_過誤申立総合Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_媒体区分
     */
    国保連送付媒体_受給訂正Ｆ_媒体区分("国保連送付媒体_受給訂正Ｆ_媒体区分"),
    /**
     * 国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名("国保連送付媒体_過誤申立Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名("国保連送付媒体_給付管理票Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名("国保連送付媒体_給付実績Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名("国保連送付媒体_共同異動Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名("国保連送付媒体_高額判定Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名("国保連送付媒体_再審申立Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給異動Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給突合Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名("国保連送付媒体_償還Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名("国保連送付媒体_支給申請Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名("国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名("国保連送付媒体_計算結果連絡Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名("国保連送付媒体_合算給付実績Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名("国保連送付媒体_過誤申立総合Ｆ_外部ＣＳＶファイル名"),
    /**
     * 国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名
     */
    国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名("国保連送付媒体_受給訂正Ｆ_外部ＣＳＶファイル名"),
    /**
     * 初期表示_高額サービス費申請登録初期
     */
    初期表示_高額サービス費申請登録初期("初期表示_高額サービス費申請登録初期"),
    /**
     * 初期表示_事業高額サービス費申請登録初期
     */
    初期表示_事業高額サービス費申請登録初期("初期表示_事業高額サービス費申請登録初期"),
    /**
     * 高額合算自己負担額補正_支払場所
     */
    高額合算自己負担額補正_支払場所("高額合算自己負担額補正_支払場所"),
    /**
     * 利用者負担割合判定管理_年度終了月日
     */
    利用者負担割合判定管理_年度終了月日("利用者負担割合判定管理_年度終了月日"),
    /**
     * 委託者名１
     */
    委託者名１("委託者名１"),
    /**
     * 委託者名２
     */
    委託者名２("委託者名２"),
    /**
     * 委託者コード
     */
    委託者コード("委託者コード"),
    /**
     * 金融機関コード
     */
    金融機関コード("金融機関コード"),
    /**
     * ＦＤ作成
     */
    ＦＤ作成("ＦＤ作成"),
    /**
     * 高額自動償還_初回申請把握基準日
     */
    高額自動償還_初回申請把握基準日("高額自動償還_初回申請把握基準日"),
    /**
     * 高額自動償還_死亡者制御
     */
    高額自動償還_死亡者制御("高額自動償還_死亡者制御");

    private final RString fullName;

    private ConfigNameDBC(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBC)の名称を返します。
     *
     * @return コンフィグ名称(DBC)の名称
     */
    public RString get名称() {
        return fullName;
    }

}
